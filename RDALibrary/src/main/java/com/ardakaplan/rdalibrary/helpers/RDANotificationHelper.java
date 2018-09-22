package com.ardakaplan.rdalibrary.helpers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

@SuppressWarnings("unused")
public final class RDANotificationHelper {

    private RDANotificationHelper() {

    }

    public static void cancelNotification(Context context, int notificationId) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        if (notificationManager != null) {

            notificationManager.cancel(notificationId);
        }
    }


    public static void showNotification(Context context,
                                        Intent intent,
                                        String title,
                                        String text,
                                        int drawableId,
                                        boolean isOngoing,
                                        boolean setTicker,
                                        boolean setSound,
                                        boolean showTime,
                                        Integer notificationId,
                                        String channelName,
                                        String channelID,
                                        Importance importance) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        registerLocationAndNotifyChannel(context, channelID, channelName, setSound, importance);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelID);

        if (RDAStringHelpers.isEmpty(title)) {
            title = "";
        }

        if (RDAStringHelpers.isEmpty(text)) {
            text = "";
        }

        builder.setContentTitle(title);

        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(text));

        builder.setContentText(text);

        builder.setPriority(Notification.PRIORITY_MAX);

        builder.setSmallIcon(drawableId);

        if (setSound) {

            builder.setDefaults(Notification.DEFAULT_SOUND);
        }

        if (setTicker) {

            builder.setTicker(text);
        }

        builder.setShowWhen(showTime);

        if (intent != null) {

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setContentIntent(pendingIntent);
        }

        if (isOngoing) {

            builder.setOngoing(true);
        }

        if (notificationId == null) {

            notificationId = -1990;
        }

        if (notificationManager != null) {

            notificationManager.notify(notificationId, builder.build());
        }
    }

    private static void registerLocationAndNotifyChannel(Context context, String notificationChannelID, String notificationChannelName, boolean setSound,
                                                         Importance importance) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

            if (notificationManager != null && notificationManager.getNotificationChannel(notificationChannelID) == null) {

                NotificationChannel notificationChannel = new NotificationChannel(notificationChannelID, notificationChannelName, NotificationManager.IMPORTANCE_HIGH);

                if (!setSound) {

                    notificationChannel.setSound(null, null);

                    notificationChannel.setShowBadge(false);

                    notificationChannel.setImportance(importance.getValue());
                }

                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public enum Importance {

        IMPORTANCE_NONE(NotificationManager.IMPORTANCE_NONE),
        IMPORTANCE_MIN(NotificationManager.IMPORTANCE_MIN),
        IMPORTANCE_LOW(NotificationManager.IMPORTANCE_LOW),
        IMPORTANCE_DEFAULT(NotificationManager.IMPORTANCE_DEFAULT),
        IMPORTANCE_HIGH(NotificationManager.IMPORTANCE_HIGH),
        IMPORTANCE_MAX(NotificationManager.IMPORTANCE_MAX);

        private int value;

        Importance(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

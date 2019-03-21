package com.ardakaplan.rdalibrary.helpers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.content.Context.NOTIFICATION_SERVICE;

@SuppressWarnings("unused")
@Singleton
public final class RDANotificationHelper {

    private Context context;

    @Inject
    RDANotificationHelper(Context context) {

        this.context = context;
    }

    public void cancelNotification(int notificationId) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        if (notificationManager != null) {

            notificationManager.cancel(notificationId);
        }
    }


    public void showNotification(Intent intent,
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
                                 boolean showBadge) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        registerLocationAndNotifyChannel(channelID, channelName, setSound, showBadge);

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

//        builder.setPriority(Notification.PRIORITY_MAX);

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

        builder.setOngoing(isOngoing);

        builder.setAutoCancel(!isOngoing);

        if (notificationId == null) {

            notificationId = -1990;
        }

        if (notificationManager != null) {

            notificationManager.notify(notificationId, builder.build());
        }
    }

    private void registerLocationAndNotifyChannel(
            String notificationChannelID,
            String notificationChannelName,
            boolean setSound,
            boolean showBadge) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

            if (notificationManager != null && notificationManager.getNotificationChannel(notificationChannelID) == null) {

                NotificationChannel notificationChannel = new NotificationChannel(notificationChannelID, notificationChannelName, NotificationManager.IMPORTANCE_DEFAULT);

                if (!setSound) {

                    notificationChannel.setSound(null, null);
                }

                notificationChannel.setShowBadge(showBadge);

                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}

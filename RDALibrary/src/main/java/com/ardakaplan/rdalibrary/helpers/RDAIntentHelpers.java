package com.ardakaplan.rdalibrary.helpers;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@SuppressWarnings({"SameParameterValue", "unused"})
@Singleton
public final class RDAIntentHelpers {

    private final Context context;

    @Inject
    RDAIntentHelpers(Context context) {

        this.context = context;
    }

    public void shareGeneral(String chooserText, String textToShare) {

        Intent shareIntent = new Intent();

        shareIntent.setAction(Intent.ACTION_SEND);

        shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);

        shareIntent.setType("text/plain");

        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent chooserIntent = Intent.createChooser(shareIntent, chooserText);

        chooserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(chooserIntent);
    }

    public void sendMessage(String phoneNo, String message) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);

        sendIntent.setData(Uri.parse("sms: " + phoneNo));

        sendIntent.putExtra("sms_body", message);

        sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(sendIntent);
    }

    public void dial(String phoneNo) {

        Intent callIntent = new Intent(Intent.ACTION_VIEW);

        callIntent.setData(Uri.parse("tel: " + phoneNo));

        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(callIntent);
    }

    public void openLinkedinPage(String linkedinSpecialLink) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://" + linkedinSpecialLink));

        final PackageManager packageManager = context.getPackageManager();

        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        if (list.isEmpty()) {

            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/" + linkedinSpecialLink));

        }

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

    public Intent getFacebookPageIntent(String pageID) {

        try {

            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);

            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + pageID));

        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + pageID));
        }
    }

    public void openBrowser(String URL) throws ActivityNotFoundException {

        final String HTTP = "http://";

        final String HTTPS = "https://";

        if (!URL.contains(HTTP) && !URL.contains(HTTPS)) {
            URL = HTTP + URL;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

    public void sendEmail(String chooserText, String[] recipients, String subject, String body) throws ActivityNotFoundException {

        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");

        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);

        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);

        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);

        Intent intent = Intent.createChooser(emailIntent, chooserText);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

    public Intent getClearCacheIntent(Class<?> cls) {

        return getClearCacheIntent(context, cls);
    }

    public static Intent getClearCacheIntent(Context context, Class<?> cls) {

        Intent intent = new Intent(context, cls);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        return intent;
    }

    public void openGooglePlayPage() {

        openGooglePlayPage(context.getPackageName());
    }

    public void openGooglePlayPage(String packageName) {

        try {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);

        } catch (ActivityNotFoundException ignored) {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getGooglePlayUrl(packageName)));

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
        }
    }

    public static String getGooglePlayUrl(String packageName) {

        return "https://play.google.com/store/apps/details?id=" + packageName;
    }

    public void openApplication(String applicationPackage) {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(applicationPackage);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }
}
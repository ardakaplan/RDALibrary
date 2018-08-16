package com.ardakaplan.rdalibrary.helpers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;

import com.ardakaplan.rdalibrary.R;

import java.util.List;

@SuppressWarnings({"SameParameterValue", "unused"})
public final class RDAIntentHelpers {

    private RDAIntentHelpers() {

    }

    public static void shareGeneral(Activity activity, String chooserText, String textToShare) {

        Intent shareIntent = new Intent();

        shareIntent.setAction(Intent.ACTION_SEND);

        shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);

        shareIntent.setType("text/plain");

        activity.startActivity(Intent.createChooser(shareIntent, chooserText));
    }

    public static void sendMessage(Activity activity, String phoneNo, String message) {

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);

        sendIntent.setData(Uri.parse("sms: " + phoneNo));

        sendIntent.putExtra("sms_body", message);

        activity.startActivity(sendIntent);
    }


    public static void dial(Activity activity, String phoneNo) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);

        callIntent.setData(Uri.parse("tel: " + phoneNo));

        activity.startActivity(callIntent);
    }

    public static void openLinkedinPage(Activity activity, String linkedinSpecialLink) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://" + linkedinSpecialLink));

        final PackageManager packageManager = activity.getPackageManager();

        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        if (list.isEmpty()) {

            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/" + linkedinSpecialLink));

        }
        activity.startActivity(intent);
    }

    public static Intent getFacebookPageIntent(Context context, String pageID) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);

            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + pageID));

        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + pageID));
        }
    }

    public static void openBrowser(Activity activity, String URL) {

        final String HTTP = "http://";

        final String HTTPS = "https://";

        if (!URL.contains(HTTP) && !URL.contains(HTTPS)) {
            URL = HTTP + URL;
        }

        try {

            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));

            activity.startActivity(myIntent);

        } catch (ActivityNotFoundException e) {

            Toast.makeText(activity, R.string.no_web_browser, Toast.LENGTH_LONG).show();
        }
    }

    public static void sendEmail(Activity activity, String chooserText, String noAppText, String[] recepients, String subject, String body) {

        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");

        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recepients);

        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);

        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);

        try {

            activity.startActivity(Intent.createChooser(emailIntent, chooserText));

        } catch (ActivityNotFoundException ex) {

            Toast.makeText(activity, noAppText, Toast.LENGTH_SHORT).show();
        }
    }

    public static Intent getClearCacheIntent() {

        Intent intent = new Intent();

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        return intent;
    }

    public static void openMarket(Activity activity) {

        try {

            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + activity.getApplication().getPackageName())));

        } catch (android.content.ActivityNotFoundException anfe) {

            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + activity.getApplication().getPackageName())));
        }
    }

    public static void openApplication(Activity activity, String applicationPackage) {

        activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(applicationPackage));
    }
}
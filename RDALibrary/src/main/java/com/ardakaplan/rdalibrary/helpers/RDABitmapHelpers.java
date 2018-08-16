package com.ardakaplan.rdalibrary.helpers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.FileNotFoundException;

/**
 * Created by Arda Kaplan on 19.11.2016.
 */

@SuppressWarnings("unused")
public final class RDABitmapHelpers {

    private RDABitmapHelpers() {

    }

    public static Bitmap decodeUri(Activity activity, Uri selectedImage) throws FileNotFoundException {

        BitmapFactory.Options o = new BitmapFactory.Options();

        o.inJustDecodeBounds = true;

        BitmapFactory.decodeStream(activity.getContentResolver().openInputStream(selectedImage), null, o);

        final int REQUIRED_SIZE = 72;

        int width_tmp = o.outWidth, height_tmp = o.outHeight;

        int scale = 1;

        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;

            height_tmp /= 2;

            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();

        o2.inSampleSize = scale;

        return BitmapFactory.decodeStream(activity.getContentResolver().openInputStream(selectedImage), null, o2);
    }
}

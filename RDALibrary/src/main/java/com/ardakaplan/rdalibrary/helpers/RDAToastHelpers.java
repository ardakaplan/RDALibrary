package com.ardakaplan.rdalibrary.helpers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

import com.rdakaplan.rdatoastlibrary.RDAToast;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 31-May-20 - 15:21
 * <p>
 * ardakaplan101@gmail.com
 */
@Singleton
public class RDAToastHelpers {

    private Context context;

    @Inject
    public RDAToastHelpers(Context context) {
        this.context = context;
    }

    public void successLong(@StringRes int stringId) {

        successLong(context.getString(stringId));
    }

    public void successLong(String message) {

        showToast(Type.SUCCESS, message, Toast.LENGTH_LONG);
    }

    public void successShort(@StringRes int stringId) {

        successShort(context.getString(stringId));
    }

    public void successShort(String message) {

        showToast(Type.SUCCESS, message, Toast.LENGTH_SHORT);
    }

    public void infoShort(@StringRes int stringId) {

        infoShort(context.getString(stringId));
    }

    public void infoShort(String message) {

        showToast(Type.INFO, message, Toast.LENGTH_SHORT);
    }

    public void infoLong(@StringRes int stringId) {

        infoLong(context.getString(stringId));
    }

    public void infoLong(String message) {

        showToast(Type.INFO, message, Toast.LENGTH_LONG);
    }

    public void warnShort(@StringRes int stringId) {

        warnShort(context.getString(stringId));
    }

    public void warnShort(String message) {

        showToast(Type.WARN, message, Toast.LENGTH_SHORT);
    }

    public void warnLong(@StringRes int stringId) {

        warnLong(context.getString(stringId));
    }

    public void warnLong(String message) {

        showToast(Type.WARN, message, Toast.LENGTH_LONG);
    }

    public void errorShort(@StringRes int stringId) {

        errorShort(context.getString(stringId));
    }

    public void errorShort(String message) {

        showToast(Type.ERROR, message, Toast.LENGTH_SHORT);
    }

    public void errorLong(@StringRes int stringId) {

        errorLong(context.getString(stringId));
    }

    public void errorLong(String message) {

        showToast(Type.ERROR, message, Toast.LENGTH_LONG);
    }

    private void showToast(Type type, String message, int duration) {

        switch (type) {

            case SUCCESS:

                RDAToast.success(context, message, duration);

                break;

            case ERROR:

                RDAToast.error(context, message, duration);

                break;

            case WARN:

                RDAToast.warning(context, message, duration);

                break;

            case INFO:

                RDAToast.info(context, message, duration);

                break;
        }
    }

    private enum Type {

        INFO,
        ERROR,
        WARN,
        SUCCESS
    }
}

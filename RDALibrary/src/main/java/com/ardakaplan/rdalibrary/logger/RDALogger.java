package com.ardakaplan.rdalibrary.logger;

import android.util.Log;

import com.google.gson.Gson;

/**
 * To use this class, once you must initialize and set log mechanism for normal/http or lifecycle
 * <p>
 * RDALogger.initialize("appname").enableLogging(true).enableLifeCycleLogging(true).enableHttpLogging(true);
 * <p>
 * And than call static info/debug/warn/error methods whereever you want
 * <p>
 * <p>
 * Created by ardakaplan on 22/09/17.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings({"SameParameterValue", "UnusedReturnValue", "unused"})
public final class RDALogger {

    private static final String IN_CLASS = "IN CLASS : ";
    private static final String IN_METHOD = "   ///   IN METHOD : ";
    private static RDALogger rdaLogger = null;
    private static boolean enableLifeCycleLogs = false;
    private static boolean enableLogs = false;
    private static boolean enableHttpLogs = false;
    private static String TAG = "";

    /**
     * singleton design pattern
     */
    private RDALogger() {

    }

    /**
     * To use RDALogger; call this first and enable logging mechanism by calling specific methods
     *
     * @param applicationName application name will be showed in logcat
     * @return rdalogger instance
     */
    public static RDALogger start(String applicationName) {

        if (rdaLogger == null) {

            rdaLogger = new RDALogger();
        }

        TAG = applicationName;

        Log.i(TAG, " RDALogger initialized by " + TAG);

        return rdaLogger;
    }

    /**
     * enables normal logging info/debug/warn/error
     *
     * @param enabled true or false
     * @return rdalogger instance
     */
    public RDALogger enableLogging(boolean enabled) {

        enableLogs = enabled;

        Log.i(TAG, " RDALogger logging enability : " + enableLogs);

        return rdaLogger;
    }

    /**
     * enables life cycle logging
     *
     * @param enabled true or false
     * @return rdalogger instance
     */
    public RDALogger enableLifeCycleLogging(boolean enabled) {

        enableLifeCycleLogs = enabled;

        Log.i(TAG, " RDALogger life cycle logging enability : " + enableLifeCycleLogs);

        return rdaLogger;
    }

    /**
     * @param enabled true or false
     * @return rdalogger instance
     */
    public RDALogger enableHttpLogging(boolean enabled) {

        enableHttpLogs = enabled;

        Log.i(TAG, " RDALogger http logging enability : " + enableHttpLogs);

        return rdaLogger;
    }

    /**
     * Every lifecycle method must use this method for logging,
     *
     * @param className className, fragment or activity
     */
    public static void logLifeCycle(String className) {

        if (enableLifeCycleLogs && enableLogs) {

            Log.d(TAG, IN_CLASS + "(" + className + ".java:0)" + IN_METHOD + StackTraceProcesses.getMethodName() + "\nMETHOD_CALLED\n ");
        }
    }

    /**
     * writing http request in different color
     * <p>
     * uses normal log level VERBOSE
     *
     * @param text object to write
     */
    public static void logHttpRequest(Object text) {

        if (enableHttpLogs && enableLogs) {

            Log.v(TAG, editMessage(text));
        }
    }

    public static void writeAsJson(Object object){

        if (enableLogs) {

            Log.d(TAG, editMessage(new Gson().toJson(object)));
        }
    }

    public static void debug(Object text) {

        if (enableLogs) {

            Log.d(TAG, editMessage(text));
        }
    }

    public static void info(Object text) {

        if (enableLogs) {

            Log.i(TAG, editMessage(text));
        }
    }

    public static void warn(Object text) {

        if (enableLogs) {

            Log.w(TAG, editMessage(text));
        }
    }

    public static void verbose(Object text) {

        if (enableLogs) {

            Log.v(TAG, editMessage(text));
        }
    }

    public static void error(Object text) {

        if (enableLogs) {

            Log.e(TAG, editMessage(text));
        }
    }

    public static void error(Throwable throwable) {

        if (throwable != null && enableLogs) {

            Log.e(TAG, "", throwable);
        }
    }

    public static void error(Object text, Throwable throwable) {

        if (throwable != null && enableLogs) {

            Log.e(TAG, editMessage(text), throwable);
        }
    }

    private static StackTraceElement getStackTrace() {

        return Thread.currentThread().getStackTrace()[8];
    }

    private static String getAnchorLink(String className, int lineNumber) {

        return "(" + className + ".java:" + lineNumber + ")";
    }

    private static String editMessage(Object text) {

        return IN_CLASS + getAnchorLink(StackTraceProcesses.getClassName(), StackTraceProcesses.getLineNumber()) + IN_METHOD + StackTraceProcesses.getMethodName() + "\n" + checkUsage(text).toString() + "\n ";
    }

    private static Object checkUsage(Object object) {

        if (object == null) {

            return "OBJECT IS NULL, NOTHING TO SHOW.";

        } else {

            return object;
        }
    }

    /*
     *All StackTrace operations should be in this class for better understanding
     */
    private static abstract class StackTraceProcesses {

        private static String getMethodName() {

            return getStackTrace().getMethodName();
        }

        private static int getLineNumber() {

            return getStackTrace().getLineNumber();
        }

        private static String getClassName() {

            String className = getStackTrace().getClassName();

            className = className.substring(className.lastIndexOf(".") + 1, className.length());

            //inner classes put $ on the classname, so we clear it off
            if (className.contains("$")) {

                className = className.substring(0, className.indexOf("$"));
            }

            return className;
        }
    }
}
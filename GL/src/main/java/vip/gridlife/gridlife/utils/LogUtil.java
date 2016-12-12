package vip.gridlife.gridlife.utils;

import android.util.Log;

/**
 * Company: SyberOS BeiJing
 * Project: TT
 * Created by 秘振博 on 2016/10/12.
 */

public class LogUtil {

    /**
     * 是否打印Log
     */
    public static final boolean showLog = false;


    public static void d(CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            d("debug", msg.toString());
    }

    public static void i(CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            i("info", msg.toString());
    }

    public static void w(CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            Log.w("info", msg.toString());
    }

    public static void e(CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            Log.e("info", msg.toString());
    }


    public static void i(String tag, CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            Log.i(tag, msg.toString());
    }

    public static void i(String tag, int msg) {
        if (showLog)
            return;
        else
            i(tag, String.valueOf(msg));
    }

    public static void i(String tag, boolean msg) {
        if (showLog)
            return;
        else
            i(tag, String.valueOf(msg));
    }

    public static void i(String tag, long msg) {
        if (showLog)
            return;
        else
            i(tag, String.valueOf(msg));
    }

    public static void i(String tag, float msg) {
        if (showLog)
            return;
        else
            i(tag, String.valueOf(msg));

    }

    public static void i(String tag, Object msg) {
        if (showLog)
            return;
        if (msg != null)
            i(tag, msg.toString());
    }


    public static void d(String tag, CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            Log.d(tag, msg.toString());
    }

    public static void d(String tag, int msg) {
        if (showLog)
            return;
        else d(tag, String.valueOf(msg));
    }

    public static void d(String tag, boolean msg) {
        if (showLog)
            return;
        else d(tag, String.valueOf(msg));
    }

    public static void d(String tag, long msg) {
        if (showLog)
            return;
        else d(tag, String.valueOf(msg));
    }

    public static void d(String tag, float msg) {
        if (showLog)
            return;
        else
            d(tag, String.valueOf(msg));
    }

    public static void d(String tag, Object msg) {
        if (showLog)
            return;
        if (msg != null)
            d(tag, msg.toString());
    }


    public static void w(String tag, CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            Log.w(tag, msg.toString());
    }

    public static void w(String tag, int msg) {
        if (showLog)
            return;
        else
            w(tag, String.valueOf(msg));
    }

    public static void w(String tag, boolean msg) {
        if (showLog)
            return;
        else
            w(tag, String.valueOf(msg));
    }

    public static void w(String tag, long msg) {
        if (showLog)
            return;
        else
            w(tag, String.valueOf(msg));
    }

    public static void w(String tag, float msg) {
        if (showLog)
            return;
        else
            w(tag, String.valueOf(msg));
    }

    public static void w(String tag, Object msg) {
        if (showLog)
            return;
        else
            w(tag, msg.toString());
    }


    public static void e(String tag, CharSequence msg) {
        if (showLog)
            return;
        if (msg != null)
            Log.e(tag, msg.toString());
    }

    public static void e(String tag, int msg) {

        if (showLog)
            return;
        else
            e(tag, String.valueOf(msg));
    }

    public static void e(String tag, boolean msg) {
        if (showLog)
            return;
        else
            e(tag, String.valueOf(msg));
    }

    public static void e(String tag, long msg) {
        if (showLog)
            return;
        else
            e(tag, String.valueOf(msg));
    }

    public static void e(String tag, float msg) {
        if (showLog)
            return;
        else
            e(tag, String.valueOf(msg));
    }

    public static void e(String tag, Object msg) {
        if (showLog)
            return;
        if (msg != null)
            e(tag, msg.toString());
    }


    public static void e(String tag, String msg, Throwable tr) {
        if (showLog)
            return;
        if (msg != null)
            Log.e(tag, msg, tr);
    }

}

package vip.gridlife.gridlife.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import vip.gridlife.gridlife.R;
import vip.gridlife.gridlife.abs.ScreenManager;


/**
 * Company: SyberOS BeiJing
 * Project: TT
 * Created by 秘振博 on 2016/10/12.
 */

public class ToastTools {
    /**
     * 创建Toast
     */
    private static Toast mToast;
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    /**
     * 创建 Handler 类用来处理Toast 的cancle方法
     */
    private static Handler mHandler = new Handler();
    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mToast.cancel();
        }
    };

    private static void showInfo(Context context, String str, int timeLength) {
        try {
            View v = LayoutInflater.from(context).inflate(R.layout.view_toast, null);
            TextView tv = (TextView) v.findViewById(R.id.tv);
            mHandler.removeCallbacks(runnable);
            if (mToast != null) {
                tv.setText(str);
            } else {
                mToast = new Toast(context);
                tv.setText(str);
            }
            mToast.setDuration(timeLength);
            tv.setGravity(Gravity.CENTER);
            tv.setMaxLines(2);
            mToast.setView(v);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示自定义Toast的方法
     *
     * @param context    上下文
     * @param msg        提示信息
     * @param timeLength 时间长度
     */
    public static void showToast(Context context, final String msg, final int timeLength) {
        showInfo(context, msg, timeLength);
    }

    /**
     * 显示自定义Toast的方法
     *
     * @param activity
     * @param msg 提示信息,时间长度默认为Toast.LENGTH_SHORT
     */
    public static void showToast(Activity activity, final String msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }

    /**
     * 显示自定义Toast的方法
     *(可有可无)
     * @param msg        提示信息
     * @param timeLength 显示时间长度
     */
    public static void showToast(final String msg, final int timeLength) {
        showToast(ScreenManager.getScreenManager().currentActivity(), msg, timeLength);
    }

    public static void showToast(final String msg) {
        showToast(ScreenManager.getScreenManager().currentActivity(), msg, ToastTools.LENGTH_SHORT);
    }

    /**
     * 显示自定义Toast的方法
     *
     * @param ctx        上下文
     * @param msg        提示信息
     * @param timeLength 时间长度
     */
    public static void showToast(final Activity ctx, final String msg, final int timeLength) {

        // 判断是否运行在主线程
        if ("main".equals(Thread.currentThread().getName())) {
            showInfo(ctx, msg, timeLength);
        } else {
            if (ctx != null)
                ctx.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showInfo(ctx, msg, timeLength);
                    }
                });
        }
    }
}


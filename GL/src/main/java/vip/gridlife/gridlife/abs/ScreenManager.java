package vip.gridlife.gridlife.abs;

/**
 * Company: SyberOS BeiJing
 * Project: TT
 * Created by 秘振博 on 2016/10/12.
 */

import android.app.Activity;

import java.util.Stack;

/**
 * Activity 管理类
 */
public class ScreenManager {
    private static Stack<Activity> activityStack;
    private static ScreenManager instance;

    private ScreenManager() {
    }

    /**
     * 获取activity 任务栈
     */
    public Stack<Activity> getActivities() {
        return activityStack;
    }

    /**
     * 单例的构造方法
     *
     * @return
     */
    public static ScreenManager getScreenManager() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    /**
     * 弹出最后一个Activity
     */
    public void popActivity() {
        Activity activity = activityStack.lastElement();
        if (activity != null) {
            activity.finish();
            activity = null;
        }
    }

    /**
     * 弹出制定Activity
     */
    public void popActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    /**
     * 获取当前的Activity
     *
     * @return
     */
    public Activity currentActivity() {
        Activity activity = null;
        try {
            activity = activityStack.lastElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activity;
    }

    /**
     * 入栈一个Activity
     *
     * @param activity
     */
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 弹出所有的Activity除了参数的那一个
     *
     * @param cls
     */
    public void popAllActivityExceptOne(Class cls) {
        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            popActivity(activity);
        }
    }

    /**
     * 弹出所有的Activity
     *
     * @param
     */
    public void popAll() {
        while (!activityStack.isEmpty()) {
            popActivity(currentActivity());
        }
    }
}

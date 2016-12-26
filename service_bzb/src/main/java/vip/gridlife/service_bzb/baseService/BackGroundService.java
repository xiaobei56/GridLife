package vip.gridlife.service_bzb.baseService;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import com.orhanobut.logger.Logger;

public class BackGroundService extends Service {
    private final static String TAG = "BackGroundService";
    private Handler handler = new Handler();

    private Runnable task = new Runnable() {
        public void run() {
            // TODOAuto-generated method stub
            handler.postDelayed(this, 3 * 1000);//设置延迟时间，此处是5秒
            //需要执行的代码
            Logger.t(TAG).e("doSomething");
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Logger.t(TAG).i("onBind()");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Logger.t(TAG).i("onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.t(TAG).i("onStartCommand()");
        new Thread() {
            @Override
            public void run() {
                handler.postDelayed(task, 10000);
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Logger.t(TAG).i("onDestroy()");
        super.onDestroy();
    }
}

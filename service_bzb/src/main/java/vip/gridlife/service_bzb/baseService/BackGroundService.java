package vip.gridlife.service_bzb.baseService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.orhanobut.logger.Logger;

public class BackGroundService extends Service {
    private final static String TAG="BackGroundService";
    public BackGroundService() {

    }

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
        new Thread(){
            @Override
            public void run() {
                try {
                    Logger.t(TAG).i("doSomething");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

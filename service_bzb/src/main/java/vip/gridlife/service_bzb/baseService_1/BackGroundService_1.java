package vip.gridlife.service_bzb.baseService_1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;

/**
 * Company: SyberOS BeiJing
 * Project: vip.gridlife.service_bzb.baseService_1
 * Created by 秘振博 on 2016/12/20.
 */

public class BackGroundService_1 extends Service {
    private final String TAG="可交互的后台服务";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Logger.t(TAG).e("onBind()");
        return new MyBinder();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Logger.t(TAG).e("onUnBind");
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder{
        public void showToast(){
            Logger.t(TAG).e("showToast");
        }
        public void showList(){
            Logger.t(TAG).e("showList");
        }
    }
}

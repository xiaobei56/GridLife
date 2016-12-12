package vip.gridlife.gridlife.UI.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import vip.gridlife.gridlife.R;
import vip.gridlife.gridlife.abs.ScreenManager;
import vip.gridlife.gridlife.utils.ToastTools;

/**
 * Company: SyberOS BeiJing
 * Project: TT
 * Created by 秘振博 on 2016/10/11.
 */
public class SplashActivity extends Activity {
    private Handler handler=new Handler();
    Runnable goMainActivity=new Runnable() {
        @Override
        public void run() {
            initNetWork();
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_right_out);
            requestCheckVersion();
            finish();

        }


    };

    /**
     * 复写onCreate方法
     * @param savedInstanceState 传入参数
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenManager.getScreenManager().pushActivity(this);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_splash);
        handler.postDelayed(goMainActivity,500);
    }

    private void initNetWork() {
        ToastTools.showToast(SplashActivity.this,"initNetWork");
    }

    private void requestCheckVersion() {
        ToastTools.showToast(SplashActivity.this,"requestCheckVersion");
    }
}

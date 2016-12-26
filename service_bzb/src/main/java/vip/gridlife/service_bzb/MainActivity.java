package vip.gridlife.service_bzb;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vip.gridlife.service_bzb.baseService.BackGroundService;
import vip.gridlife.service_bzb.baseService_1.BackGroundService_1;

public class MainActivity extends AppCompatActivity {
    private Button btn_open, btn_close;
    private Button btn_open_1, btn_close_1;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = new Intent(this, BackGroundService.class);
        final Intent intent_1 = new Intent(this, BackGroundService_1.class);

        setContentView(R.layout.activity_main);
        //后台服务
        btn_open = (Button) findViewById(R.id.btn_open);
        btn_close = (Button) findViewById(R.id.btn_close);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });


        //可交互的后台服务
        btn_open_1 = (Button) findViewById(R.id.btn_open_1);
        btn_close_1 = (Button) findViewById(R.id.btn_close_1);

        bindService(intent_1, conn, BIND_AUTO_CREATE);
        btn_close_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });

    }


    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BackGroundService_1.MyBinder myBinder = (BackGroundService_1.MyBinder) service;
            myBinder.showToast();
            myBinder.showList();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}

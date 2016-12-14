package vip.gridlife.service_bzb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vip.gridlife.service_bzb.baseService.BackGroundService;

public class MainActivity extends AppCompatActivity {
    private Button btn_open,btn_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_open = (Button) findViewById(R.id.btn_open);
        btn_close= (Button) findViewById(R.id.btn_close);
        final Intent intent=new Intent(this,BackGroundService.class);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
    }
}

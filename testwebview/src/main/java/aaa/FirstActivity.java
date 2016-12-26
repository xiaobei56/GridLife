package aaa;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vip.gridlife.testwebview.R;

/**
 * Company: SyberOS BeiJing
 * Project: aaa
 * Created by 秘振博 on 2016/12/23.
 */

public class FirstActivity extends Activity {
    private Button btnGoURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        btnGoURL= (Button) findViewById(R.id.btn_GoURL);
        btnGoURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.gridlife.cn");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}

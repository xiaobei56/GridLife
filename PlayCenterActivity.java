import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.letv.skin.simple.utils.LetvBaseHelper.PlayerRenderCallback;
import com.letv.skin.simple.utils.LetvNormalAndPanoHelper;
import com.letv.skin.v4.V4PlaySkin;

public class PlayCenterActivity
        extends Activity {
    public static final String DATA = "data";
    private Bundle bundle;
    private LetvNormalAndPanoHelper playHelper;
    private V4PlaySkin skin;

    private void initData() {
        Intent localIntent = getIntent();
        if (localIntent != null) {
            this.bundle = localIntent.getBundleExtra("data");
            if (this.bundle == null) {
                Toast.makeText(this, "no data", 1).show();
            }
        }
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        if (this.playHelper != null) {
            this.playHelper.onConfigurationChanged(paramConfiguration);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        getWindow().setFormat(-3);
        getWindow().addFlags(128);
        setContentView(2130903275);
        initData();
        this.skin = ((V4PlaySkin) findViewById(2131559311));
        this.playHelper = new LetvNormalAndPanoHelper();
        this.playHelper.init(getApplicationContext(), this.bundle, this.skin);
        this.playHelper.renderCallback = new LetvBaseHelper.PlayerRenderCallback() {
            public void onRender() {
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.playHelper != null) {
            this.playHelper.onDestroy();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.playHelper != null) {
            this.playHelper.onPause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.playHelper != null) {
            this.playHelper.onResume();
        }
    }
}
package vip.gridlife.testwebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private WebView webView;
    private TextView textView;
    private StringBuilder url=new StringBuilder("http://");
    private String s;
    private StringBuilder u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        webView = (WebView) findViewById(R.id.webView);
        textView = (TextView) findViewById(R.id.tv_url);

//        webView.loadData("...................", "text/html", null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {

//                    }
//                }).start();
                s = textView.getText().toString().trim();
                Logger.e(s);
                if (s != null)
                   url.append(s);
                Logger.e(String.valueOf(url));
                if (s.isEmpty() || s.length() == 0)
                    url = new StringBuilder("http://www.xiaobei89.top");
                webView.addJavascriptInterface(new JsObject(), "injectedObject");
                webView.canGoBack();
                webView.loadUrl(url.toString());
                s=new String("");
                url=new StringBuilder("http://");
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {// keyCode代表按键的数字标示符
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            } else {
                System.exit(0);
            }
        }

        return super.onKeyDown(keyCode, event);
    }
    class JsObject {
        @JavascriptInterface
        public String toString() {
            return "injectedObject";
        }
    }
}




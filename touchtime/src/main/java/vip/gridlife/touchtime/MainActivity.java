package vip.gridlife.touchtime;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button, btnClear;
    private TextView textView;
    private TextView textView1;
    private static long lastTime = 0;
    private static long startTime = 0;
    private static long totalTime = 0;
    private String s;
    private SpannableString spannableString;
    private ForegroundColorSpan colorSpan;
    private Handler handler = new Handler();
    private int len;
    private long t1 = 0;
    private long t2 = 0;
    private long t3 = 0;
    private Runnable task = new Runnable() {



        @Override
        public void run() {
            handler.postDelayed(this, 5);
            t1 = System.currentTimeMillis();
//            lastTime=+5;
            totalTime = System.currentTimeMillis() - startTime;
            s = totalTime + " ms";
            len = s.length();
            System.out.println("len:" + len);
            spannableString = new SpannableString(s + "");
            colorSpan = new ForegroundColorSpan(Color.parseColor("#f15b6c"));
            spannableString.setSpan(colorSpan, len - 2, len, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            textView.setText(spannableString);
            t2 = System.currentTimeMillis();
            t3 += t2 - t1;
            textView1.setText(t3 + "");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_press);
        btnClear = (Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3 = 0;
                textView.setText("0 ms");
                textView1.setText("0 ms");
            }
        });

        textView = (TextView) findViewById(R.id.tv_show);
        textView1 = (TextView) findViewById(R.id.tv_show1);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //获取当前时间
                    startTime = System.currentTimeMillis();
                    handler.post(task);
                } else if (event.getAction() == MotionEvent.ACTION_UP)
                    handler.removeCallbacks(task);
                return false;
            }
        });


    }
}

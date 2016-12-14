package vip.gridlife.pulseview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PC80bSectionView extends View {
    private List<Integer> data = new ArrayList<>();  //    数据源
    private float width;    //   控件宽
    private float height;   //   控件高
    private PulseView pulseView;
    //    随手指移动的正方形的中心
    private float rec_centerX;
    private float rec_centerY;
    private Rect rect = new Rect();

    public PC80bSectionView(Context context) {
        this(context,null,0);
    }

    public PC80bSectionView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PC80bSectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 画随手指移动的正方形
     * @param canvas
     * @param paint
     */
    private void drawRect(Canvas canvas, Paint paint) {
        rec_centerY = (height / 2.0F);
        if (rec_centerX < height / 2.0F) {
            rec_centerX = (height / 2.0F);
        }

        if (rec_centerX > width - height / 2.0F) {
            rec_centerX = (width - height / 2.0F);
        }

        rect.left = ((int) (rec_centerX - height / 2.0F));
        rect.right = ((int) (rec_centerX + height / 2.0F));
        rect.top = ((int) (rec_centerY + height / 2.0F));
        rect.bottom = ((int) (rec_centerY - height / 2.0F));

        canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
    }

    /**
     * 画波形
     * @param canvas
     * @param paint
     */
    private void drawLine(Canvas canvas, Paint paint) {
        paint.setColor(Color.GREEN);
        if (this.data.size() > 1){
            for (int i = 1; i < data.size(); i++){
                //    4500表示每次心电仪传输过来的30秒数据的个数
                canvas.drawLine((i - 1) * (width / 4500.0F), height - (data.get(i - 1)),
                        i * (width / 4500.0F), height - data.get(i), paint);
            }
        }
    }

    public void postData(List<Integer> list) {
        data.addAll(list);
        postInvalidate();
    }

    public void clearData() {
        if ((data != null) && (data.size() > 1)){
            data.clear();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(2.0F);

        drawRect(canvas, paint);
        drawLine(canvas, paint);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:

                rec_centerX = ((int) event.getX());
                invalidate();
                //    每次正方形发生移动计算出其中包含区间并将响应区间数据发送至pulseView显示
                if (pulseView != null) {
                    List<Integer> list = new ArrayList<>();

                    for (int i = 0; i < data.size(); i++) {
                        if ((i >= (int) (rect.left * 4500.0F / width)) && (i <= (int) (rect.right * 4500.0F / width))){
                            list.add(data.get(i) * 10);
                        }
                    }
                    pulseView.addDataByPC80B(list);
                }
        }
        return true;
    }

    public void setPulseView(PulseView pulseView) {
        this.pulseView = pulseView;
    }
}
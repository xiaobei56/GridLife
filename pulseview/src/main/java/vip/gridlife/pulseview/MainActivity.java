package vip.gridlife.pulseview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import vip.gridlife.pulseview.view.PulseView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PulseView pulseView= (PulseView) findViewById(R.id.pulseView);
        List<Integer> list= new ArrayList<>();
        int[] array=new int[]{35,21,6,7,2,45,7,2,7,32,7,32,7,3,7,3,5,9,32,1,6,8,4,3,2,5,3,1,5,6,7,2,21,54,6,73,45};
        for(int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        pulseView.setData(list);
    }
}

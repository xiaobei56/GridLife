package vip.gridlife.gridlife.UI.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vip.gridlife.gridlife.R;
import vip.gridlife.gridlife.adapter.TestRecyclerAdapter;

/**
 * Created by Jaeger on 16/8/11.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */
public class GridFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragement_communicate, container, false);
        Context context=getActivity().getApplicationContext();
        //开始设置RecyclerView
        mRecyclerView= (RecyclerView) v.findViewById(R.id.rv_grid);
        //设置固定大小
        mRecyclerView.setHasFixedSize(true);
        //创建线性布局
        mLayoutManager=new GridLayoutManager(context,4);
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //给RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        //创建适配器，并且设置
        mAdapter=new TestRecyclerAdapter(getActivity().getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }


}

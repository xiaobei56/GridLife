package vip.gridlife.gridlife.UI.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vip.gridlife.gridlife.R;


public class GnosisFragment extends Fragment {
    private ViewPager vPStudy;
    private ViewPager vpStudy;
    PagerAdapter adapter=new StudyAdapter();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_study, container, false);
        vpStudy = (ViewPager) view.findViewById(R.id.vp_study);
        vpStudy.setAdapter(new StudyAdapter());
        return view;
    }

    private class StudyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}
package vip.gridlife.gridlife.UI.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.Random;

import vip.gridlife.gridlife.R;
import vip.gridlife.gridlife.UI.fragment.GnosisFragment;
import vip.gridlife.gridlife.UI.fragment.GridFragment;
import vip.gridlife.gridlife.UI.fragment.MeFragment;
import vip.gridlife.gridlife.UI.fragment.ShowFragment;
import vip.gridlife.gridlife.abs.ScreenManager;
import vip.gridlife.gridlife.utils.LogUtil;

public class MainActivity extends AppCompatActivity {
    private ViewPager mVpHome;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    /**
     * 是否再通知栏也显示内容.显示效果上就是,通知栏是否为透明的
     */
    private boolean isFullScreen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        ScreenManager.getScreenManager().pushActivity(MainActivity.this);
        setStatusBar();
        mVpHome = (ViewPager) findViewById(R.id.vp_home);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.bottom_study_icon, "Grid"))
                .addItem(new BottomNavigationItem(R.mipmap.bottom_show_icon, "Gnosis"))
                .addItem(new BottomNavigationItem(R.mipmap.bottom_communicate_icon, "Show"))
                .addItem(new BottomNavigationItem(R.mipmap.bottom_me_icon, "Me"))
                .initialise();

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mVpHome.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        mFragmentList.add(new GridFragment());
        mFragmentList.add(new GnosisFragment());
        mFragmentList.add(new ShowFragment());
        mFragmentList.add(new MeFragment());

        mVpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomNavigationBar.selectTab(position);
                switch (position) {
                    case 0:
                        isFullScreen = false;
//                        通知栏半透明
                        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, null);
                        break;
                    case 1:
                        isFullScreen = false;
//                        通知栏半透明
                        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, null);
                        break;
                    case 2:
                        isFullScreen = false;
//                        通知栏半透明
                        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, null);
                        break;
                    case 3:
                        isFullScreen = true;
//                        通知栏半透明
                        StatusBarUtil.setTransparentForImageViewInFragment(MainActivity.this, null);
                        break;
                    default:
                        if (isFullScreen) {
                            resetFragmentView(mFragmentList.get(position));
                        }
                        Random random = new Random();
                        int color = 0xff000000 | random.nextInt(0xffffff);
                        LogUtil.e("color:" + color);
                        StatusBarUtil.setColor(MainActivity.this, color, 0);
//                        ((ShowFragment) mFragmentList.get(position)).setTvTitleBackgroundColor(color);
                        break;
                }
            }

            /**
             * Called when the scroll state changes. Useful for discovering when the user
             * begins dragging, when the pager is automatically settling to the current page,
             * or when it is fully stopped/idle.
             *
             * @param state The new scroll state.
             * @see ViewPager#SCROLL_STATE_IDLE 0 什么都没做
             * @see ViewPager#SCROLL_STATE_DRAGGING 1 正在滑动
             * @see ViewPager#SCROLL_STATE_SETTLING 2 滑动完毕
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mVpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {
//        Rect rectangle= new Rect();
//        Window window= getWindow();
//        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
//        int statusBarHeight= rectangle.top;
        int statusHeight = -1;
        try {
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }
    /**
     * 重置FragmentView
     *
     * @param fragment
     */
    public void resetFragmentView(Fragment fragment) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View contentView = findViewById(android.R.id.content);
            if (contentView != null) {
                ViewGroup rootView;
                rootView = (ViewGroup) ((ViewGroup) contentView).getChildAt(0);
                if (rootView.getPaddingTop() != 0) {
                    rootView.setPadding(0, 0, 0, 0);
                }
            }
            if (fragment.getView() != null)
                fragment.getView().setPadding(0, getStatusBarHeight(this), 0, 0);
        }
    }

    /**
     * 获得状态栏高度
     *
     * @param context 当前context
     * @return 高度
     */
    private static int getStatusBarHeight(Context context) {

        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

}

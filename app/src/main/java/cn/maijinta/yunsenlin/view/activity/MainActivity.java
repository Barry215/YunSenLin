package cn.maijinta.yunsenlin.view.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;
import cn.maijinta.yunsenlin.view.adapter.FragmentViewPagerAdapter;
import cn.maijinta.yunsenlin.view.fragment.AnalysisFragment;
import cn.maijinta.yunsenlin.view.fragment.CalculateFragment;
import cn.maijinta.yunsenlin.view.fragment.FinanceFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterCreate() {
        initTabLayout();
        initTabListener();
    }

    private void initTabListener() {

    }

    private void initTabLayout() {
        List<String> titles = new ArrayList<>();
        titles.add("计算");
        titles.add("财务");
        titles.add("分析");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new CalculateFragment());
        fragments.add(new FinanceFragment());
        fragments.add(new AnalysisFragment());
        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(),fragments,titles);
        viewPager.setAdapter(fragmentViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}

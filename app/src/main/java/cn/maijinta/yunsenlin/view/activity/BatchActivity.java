package cn.maijinta.yunsenlin.view.activity;

import android.support.annotation.BinderThread;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;
import cn.maijinta.yunsenlin.view.activity.base.OnItemClickListener;
import cn.maijinta.yunsenlin.view.adapter.BatchCalculatorAdapter;
import cn.maijinta.yunsenlin.view.adapter.CalculatorAdapter;
import cn.maijinta.yunsenlin.view.adapter.FragmentViewPagerAdapter;
import cn.maijinta.yunsenlin.view.fragment.AnalysisFragment;
import cn.maijinta.yunsenlin.view.fragment.CalculateFragment;
import cn.maijinta.yunsenlin.view.fragment.FinanceFragment;
import cn.maijinta.yunsenlin.view.fragment.WeightFragment;
import cn.maijinta.yunsenlin.view.fragment.YuanmuFragment;
import cn.maijinta.yunsenlin.view.fragment.YuantiaoFragment;

/**
 * Created by frank on 17/1/24.
 */

public class BatchActivity extends BaseActivity {

    @BindView(R.id.tabLayout_batch)
    TabLayout tabLayout;

    @BindView(R.id.vp_batch)
    ViewPager viewPager;

    @BindView(R.id.toolbar_batch)
    Toolbar toolbar;

    @BindView(R.id.recy_batch)
    RecyclerView recyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_batch;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        initTabLayout();
        initCalculator();
    }

    private void initCalculator() {
        List<String> cal_items = new ArrayList<>();
        cal_items.add("7");
        cal_items.add("8");
        cal_items.add("9");
        cal_items.add("×");
        cal_items.add("4");
        cal_items.add("5");
        cal_items.add("6");
        cal_items.add("up");
        cal_items.add("1");
        cal_items.add("2");
        cal_items.add("3");
        cal_items.add("down");
        cal_items.add("0");
        cal_items.add(".");
        cal_items.add("添加");

        List<Integer> cal_drawables = new ArrayList<>();
        cal_drawables.add(R.drawable.up_cal);
        cal_drawables.add(R.drawable.down_cal);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        //每个item的宽度设置
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 14){
                    return 2;
                }else {
                    return 1;
                }
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        BatchCalculatorAdapter batchCalculatorAdapter = new BatchCalculatorAdapter(this,cal_items,cal_drawables);
        recyclerView.setAdapter(batchCalculatorAdapter);
        batchCalculatorAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(BatchActivity.this, "我是"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.drawable.arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initTabLayout() {
        List<String> titles = new ArrayList<>();
        titles.add("原木/椽木");
        titles.add("原条/锯材");
        titles.add("称重/估值");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new YuanmuFragment());
        fragments.add(new YuantiaoFragment());
        fragments.add(new WeightFragment());
        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(),fragments,titles);
        viewPager.setAdapter(fragmentViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

package cn.maijinta.yunsenlin.view.activity;

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
import cn.maijinta.yunsenlin.view.adapter.CalculateAdapter;
import cn.maijinta.yunsenlin.view.adapter.CalculatorAdapter;

/**
 * Created by frank on 16/12/11.
 */

public class CalculatorActivity extends BaseActivity {

    @BindView(R.id.toolbar_calculator)
    Toolbar toolbar;

    @BindView(R.id.recyclerView_calculate)
    RecyclerView recyclerView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_calculator;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        initPageView();
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

    private void initPageView() {
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
        cal_items.add("=");

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
        CalculatorAdapter calculatorAdapter = new CalculatorAdapter(this,cal_items,cal_drawables);
        recyclerView.setAdapter(calculatorAdapter);
        calculatorAdapter.setOnItemClickListener(new CalculatorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(CalculatorActivity.this, "我是"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }


}

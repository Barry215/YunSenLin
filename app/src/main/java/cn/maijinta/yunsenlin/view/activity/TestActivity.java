package cn.maijinta.yunsenlin.view.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;
import cn.maijinta.yunsenlin.view.activity.base.OnItemClickListener;
import cn.maijinta.yunsenlin.view.adapter.BatchCalculatorAdapter;
import cn.maijinta.yunsenlin.view.fragment.base.BaseFragment;

/**
 * Created by frank on 17/1/24.
 */

public class TestActivity extends BaseActivity {

    @BindView(R.id.recy_test)
    RecyclerView recyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void afterCreate() {
        initTest();
    }

    private void initTest() {
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
                Toast.makeText(TestActivity.this, "我是"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

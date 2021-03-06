package cn.maijinta.yunsenlin.view.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.adapter.CalculateAdapter;
import cn.maijinta.yunsenlin.view.fragment.base.BaseFragment;

/**
 * Created by frank on 16/11/30.
 */
public class CalculateFragment extends BaseFragment {

    @BindView(R.id.recyclerView_cal)
    RecyclerView recyclerView;

    @Override
    protected int getPageLayoutId() {
        return R.layout.fragment_calculate;
    }

    @Override
    protected void initPageView(View rootView) {
        List<String> titles = new ArrayList<>();
        titles.add("原木计算器");
        titles.add("原条计算器");
        titles.add("锯材计算器");
        titles.add("计算记录");
        titles.add("批量计算");
        titles.add("估值计算");
        titles.add("价格设定");
        titles.add("拍照计算");
        titles.add("计算规则");

        List<Integer> drawableList = new ArrayList<>();
        drawableList.add(R.drawable.calculate_1);
        drawableList.add(R.drawable.calculate_2);
        drawableList.add(R.drawable.calculate_3);
        drawableList.add(R.drawable.calculate_4);
        drawableList.add(R.drawable.calculate_5);
        drawableList.add(R.drawable.calculate_6);
        drawableList.add(R.drawable.calculate_7);
        drawableList.add(R.drawable.calculate_8);
        drawableList.add(R.drawable.calculate_9);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        //每个item的宽度设置
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 1;
//            }
//        });
        recyclerView.setLayoutManager(gridLayoutManager);
        CalculateAdapter calculateAdapter = new CalculateAdapter(titles,drawableList,getActivity());
        recyclerView.setAdapter(calculateAdapter);
    }
}

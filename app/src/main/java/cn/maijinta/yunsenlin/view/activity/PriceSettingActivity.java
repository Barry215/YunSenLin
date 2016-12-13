package cn.maijinta.yunsenlin.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;
import cn.maijinta.yunsenlin.view.adapter.PriceSettingAdapter1;
import cn.maijinta.yunsenlin.view.adapter.PriceSettingAdapter2;

/**
 * Created by frank on 16/12/13.
 */

public class PriceSettingActivity extends BaseActivity {

    @BindView(R.id.toolbar_price_setting)
    Toolbar toolbar;

    @BindView(R.id.recy_price_set_1)
    RecyclerView recyclerView_1;

    @BindView(R.id.recy_price_set_2)
    RecyclerView recyclerView_2;

    @BindView(R.id.recy_price_set_3)
    RecyclerView recyclerView_3;

    @Override
    public int getLayoutId() {
        return R.layout.activity_price_setting;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        initPageView();
    }

    private void initPageView() {
        initRecyclerView();
    }

    private void initRecyclerView(){
        List<String> length_list = new ArrayList<>();
        length_list.add("1.3");
        length_list.add("1.3");
        length_list.add("2.6");
        length_list.add("2.6");
        length_list.add("2");

        List<String> diameter_list = new ArrayList<>();
        diameter_list.add("4-12");
        diameter_list.add("13-120");
        diameter_list.add("4-12");
        diameter_list.add("13-120");
        diameter_list.add("4-12");

        List<String> price_list = new ArrayList<>();
        price_list.add("350");
        price_list.add("500");
        price_list.add("400");
        price_list.add("550");
        price_list.add("300");

        List<String> format_list = new ArrayList<>();
        format_list.add("3800×200×10");
        format_list.add("3800×200×20");

        List<String> price_list_2 = new ArrayList<>();
        price_list_2.add("350");
        price_list_2.add("500");

        PriceSettingAdapter1 priceSettingAdapter1 = new PriceSettingAdapter1(length_list,diameter_list,price_list,this);
        recyclerView_1.setLayoutManager(new LinearLayoutManager(recyclerView_1.getContext()));
        recyclerView_1.setAdapter(priceSettingAdapter1);

        recyclerView_2.setLayoutManager(new LinearLayoutManager(recyclerView_2.getContext()));
        recyclerView_2.setAdapter(priceSettingAdapter1);

        PriceSettingAdapter2 priceSettingAdapter2 = new PriceSettingAdapter2(format_list,price_list_2,this);
        recyclerView_3.setLayoutManager(new LinearLayoutManager(recyclerView_3.getContext()));
        recyclerView_3.setAdapter(priceSettingAdapter2);
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
}

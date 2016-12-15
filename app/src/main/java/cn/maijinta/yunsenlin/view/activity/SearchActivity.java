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
import cn.maijinta.yunsenlin.view.adapter.SearchAdapter;

/**
 * Created by frank on 16/12/15.
 */

public class SearchActivity extends BaseActivity {

    @BindView(R.id.toolbar_search)
    Toolbar toolbar;

    @BindView(R.id.recy_search)
    RecyclerView recyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        initPageView();
    }

    private void initPageView() {
        List<String> dataList = new ArrayList<>();
        dataList.add("柳木");
        dataList.add("杨木");
        dataList.add("乔木");
        dataList.add("灌木");
        dataList.add("古木");
        dataList.add("柳木");
        dataList.add("杨木");
        dataList.add("乔木");
        dataList.add("灌木");
        dataList.add("古木");

        SearchAdapter searchAdapter = new SearchAdapter(this,dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(searchAdapter);

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

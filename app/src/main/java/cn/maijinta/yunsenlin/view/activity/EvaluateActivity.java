package cn.maijinta.yunsenlin.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 16/12/15.
 */

public class EvaluateActivity extends BaseActivity {

    @BindView(R.id.toolbar_evaluate)
    Toolbar toolbar;

    @BindView(R.id.btn_evaluate_1)
    Button btn_1;

    @BindView(R.id.btn_evaluate_2)
    Button btn_2;

    @OnClick(R.id.btn_evaluate_1) void evaluate_1() {
        Intent intent_1 = new Intent(this,SearchActivity.class);
        startActivity(intent_1);
    }

    @OnClick(R.id.btn_evaluate_2) void evaluate_2() {
        Intent intent_2 = new Intent(this,SearchActivity.class);
        startActivity(intent_2);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_evaluate;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
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

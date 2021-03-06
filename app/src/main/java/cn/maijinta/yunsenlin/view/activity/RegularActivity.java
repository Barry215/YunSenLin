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
 * Created by frank on 17/1/18.
 */

public class RegularActivity extends BaseActivity {

    @BindView(R.id.btn_regular_1)
    Button btn_1;

    @BindView(R.id.btn_regular_2)
    Button btn_2;

    @BindView(R.id.btn_regular_3)
    Button btn_3;

    @BindView(R.id.btn_regular_4)
    Button btn_4;

    @BindView(R.id.toolbar_regular)
    Toolbar toolbar;

    @OnClick(R.id.btn_regular_1) void regular_1() {
        Intent intent_1 = new Intent(this,CalculateRuleActivity.class);
        startActivity(intent_1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_regular;
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

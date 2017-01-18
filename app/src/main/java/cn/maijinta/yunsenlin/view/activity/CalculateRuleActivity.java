package cn.maijinta.yunsenlin.view.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 17/1/18.
 */

public class CalculateRuleActivity extends BaseActivity {

    @BindView(R.id.toolbar_regular_rule)
    Toolbar toolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_calculate_rule;
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

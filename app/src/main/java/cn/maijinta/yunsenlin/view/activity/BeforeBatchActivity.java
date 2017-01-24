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
 * Created by frank on 17/1/24.
 */

public class BeforeBatchActivity extends BaseActivity {

    @BindView(R.id.btn_bef_batch_3)
    Button btn_3;

    @BindView(R.id.toolbar_bef_batch)
    Toolbar toolbar;

    @OnClick(R.id.btn_bef_batch_3) void click_btn_3() {
        Intent intent_1 = new Intent(this,BatchActivity.class);
        startActivity(intent_1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_before_batch;
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

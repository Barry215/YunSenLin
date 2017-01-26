package cn.maijinta.yunsenlin.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 17/1/26.
 */

public class FindPsdSucActivity extends BaseActivity {

    @BindView(R.id.toolbar_find_psd_suc)
    Toolbar toolbar;

    @BindView(R.id.tv_find_psd_suc_1)
    TextView textView;

    @OnClick(R.id.tv_find_psd_suc_1) void click_tv() {
        Intent intent_1 = new Intent(this,LoginActivity.class);
        startActivity(intent_1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_find_psd_suc;
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

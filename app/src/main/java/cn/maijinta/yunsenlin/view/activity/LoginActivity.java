package cn.maijinta.yunsenlin.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 16/12/7.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.toolbar_login_1)
    Toolbar toolbar;

    @BindView(R.id.tv_login_3)
    TextView textView_3;

    @OnClick(R.id.tv_login_3) void register() {
        Intent intent_1 = new Intent(this, RegisterPhoneActivity.class);
        startActivity(intent_1);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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

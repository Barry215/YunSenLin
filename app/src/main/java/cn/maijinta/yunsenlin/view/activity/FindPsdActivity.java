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
 * Created by frank on 17/1/26.
 */

public class FindPsdActivity extends BaseActivity {

    @BindView(R.id.toolbar_find_psd)
    Toolbar toolbar;

    @BindView(R.id.btn_find_psd)
    Button button;

    @OnClick(R.id.btn_find_psd) void click_btn() {
        Intent intent_1 = new Intent(this,FindPsdSucActivity.class);
        startActivity(intent_1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_find_psd;
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

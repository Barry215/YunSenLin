package cn.maijinta.yunsenlin.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 17/1/24.
 */

public class BeforeBatchActivity extends BaseActivity {

    private boolean first_selected = true;

    @BindView(R.id.btn_bef_batch_1)
    Button btn_1;

    @BindView(R.id.btn_bef_batch_2)
    Button btn_2;

    @BindView(R.id.btn_bef_batch_3)
    Button btn_3;

    @BindView(R.id.toolbar_bef_batch)
    Toolbar toolbar;

    @BindView(R.id.ed_bef_batch)
    EditText ed_batch;

    @OnClick(R.id.btn_bef_batch_1) void click_btn_1() {
        if (!first_selected){
            btn_1.setBackground(getDrawable(R.drawable.btn_green_selected));
            btn_2.setBackground(getDrawable(R.drawable.btn_green_normal));
            first_selected = !first_selected;
        }
    }

    @OnClick(R.id.btn_bef_batch_2) void click_btn_2() {
        if (first_selected){
            btn_1.setBackground(getDrawable(R.drawable.btn_green_normal));
            btn_2.setBackground(getDrawable(R.drawable.btn_green_selected));
            first_selected = !first_selected;
        }
    }

    @OnClick(R.id.btn_bef_batch_3) void click_btn_3() {
        if (!ed_batch.getText().toString().trim().equals("")){
            Intent intent_1 = new Intent(this,BatchActivity.class);
            startActivity(intent_1);
        }else {
            Toast.makeText(this, "您还没填写信息", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_before_batch;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        initPageView();
    }

    private void initPageView() {
        ed_batch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().trim().equals("")){
                    btn_3.setBackground(getDrawable(R.drawable.btn_green_selected));
                }else {
                    btn_3.setBackground(getDrawable(R.drawable.btn_green_normal));
                }
            }
        });
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

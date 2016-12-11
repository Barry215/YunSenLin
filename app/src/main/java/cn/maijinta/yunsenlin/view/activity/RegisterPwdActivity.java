package cn.maijinta.yunsenlin.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 16/12/11.
 */

public class RegisterPwdActivity extends BaseActivity {

    @BindView(R.id.toolbar_register_pwd_1)
    Toolbar toolbar;

    @BindView(R.id.ed_register_pwd_1)
    EditText ed_1;

    @BindView(R.id.ed_register_pwd_2)
    EditText ed_2;

    @BindView(R.id.btn_register_pwd_1)
    Button btn;


    @OnClick(R.id.btn_register_pwd_1) void register_pwd_next(){
        if (ed_1.getText().toString().equals(ed_2.getText().toString())
                && ed_1.getText().toString().length() >= 6){
            Intent intent_1 = new Intent(this, MainActivity.class);
            startActivity(intent_1);
        }else {
            Toast.makeText(this, "您两次密码输入不一致或字数小于6", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_pwd;
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

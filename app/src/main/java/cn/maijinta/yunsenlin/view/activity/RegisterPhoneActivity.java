package cn.maijinta.yunsenlin.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 16/12/7.
 */

public class RegisterPhoneActivity extends BaseActivity {

    @BindView(R.id.toolbar_register_phone_1)
    Toolbar toolbar;

    @BindView(R.id.ed_register_phone_1)
    EditText editText;

    @BindView(R.id.btn_register_phone_1)
    Button button;


    private static final String NUMBER_PATTERN = "[1][34578]\\d{9}";

    @OnClick(R.id.btn_register_phone_1) void register_next() {
        if (validatePhone(editText.getText().toString())){
            Intent intent_1 = new Intent(this, RegisterCodeActivity.class);
            startActivity(intent_1);
        }else {
            Toast.makeText(this, "您的手机号输入有误！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_phone;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        editTextInitListener();
    }

    private void editTextInitListener() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String phoneNum = charSequence.toString();
                if (phoneNum.length() == 11){
                    button.setEnabled(true);
                    button.setBackground(getDrawable(R.drawable.btn_register_next_true));
                }else {
                    button.setEnabled(false);
                    button.setBackground(getDrawable(R.drawable.btn_register_next));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

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

    public boolean validatePhone(String num){
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
}

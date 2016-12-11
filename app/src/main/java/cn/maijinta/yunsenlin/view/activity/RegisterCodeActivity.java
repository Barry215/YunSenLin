package cn.maijinta.yunsenlin.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;

/**
 * Created by frank on 16/12/7.
 */

public class RegisterCodeActivity extends BaseActivity {

    @BindView(R.id.toolbar_register_code_1)
    Toolbar toolbar;

    @BindView(R.id.ed_register_code_1)
    EditText editText;

    @BindView(R.id.btn_register_code_1)
    Button btn_1;

    @BindView(R.id.btn_register_code_2)
    Button btn_2;

    @OnClick(R.id.btn_register_code_1) void register_code_next(){
        Intent intent_1 = new Intent(this, RegisterPwdActivity.class);
        startActivity(intent_1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_code;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        editTextInitListener();
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


    private void editTextInitListener() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str_code = charSequence.toString();
                if (str_code.length() == 4){
                    btn_1.setEnabled(true);
                    btn_1.setBackground(getDrawable(R.drawable.btn_register_next_true));
                }else {
                    btn_1.setEnabled(false);
                    btn_1.setBackground(getDrawable(R.drawable.btn_register_next));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }




}

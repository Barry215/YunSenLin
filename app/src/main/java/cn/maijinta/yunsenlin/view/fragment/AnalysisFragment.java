package cn.maijinta.yunsenlin.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.FindPsdActivity;
import cn.maijinta.yunsenlin.view.activity.LoginActivity;
import cn.maijinta.yunsenlin.view.activity.RegisterPhoneActivity;
import cn.maijinta.yunsenlin.view.fragment.base.BaseFragment;

/**
 * Created by frank on 16/11/30.
 */

public class AnalysisFragment extends BaseFragment {
    @BindView(R.id.btn_mpt_login_1)
    Button button;

    @BindView(R.id.tv_mpt_login_2)
    TextView tv_1;

    @BindView(R.id.tv_mpt_login_3)
    TextView tv_2;

    @OnClick(R.id.btn_mpt_login_1) void click_btn() {
        Intent intent_1 = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent_1);
    }

    @OnClick(R.id.tv_mpt_login_2) void click_tv_1() {
        Intent intent_2 = new Intent(getActivity(),RegisterPhoneActivity.class);
        startActivity(intent_2);
    }

    @OnClick(R.id.tv_mpt_login_3) void click_tv_2() {
        Intent intent_3 = new Intent(getActivity(),FindPsdActivity.class);
        startActivity(intent_3);
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.prompt_login;
    }

    @Override
    protected void initPageView(View rootView) {

    }
}

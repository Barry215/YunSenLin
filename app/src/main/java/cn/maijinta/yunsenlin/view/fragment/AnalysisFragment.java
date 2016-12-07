package cn.maijinta.yunsenlin.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.LoginActivity;
import cn.maijinta.yunsenlin.view.fragment.base.BaseFragment;

/**
 * Created by frank on 16/11/30.
 */

public class AnalysisFragment extends BaseFragment {
    @BindView(R.id.btn_mpt_login_1)
    Button button;

    @Override
    protected int getPageLayoutId() {
        return R.layout.prompt_login;
    }

    @Override
    protected void initPageView(View rootView) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_1 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent_1);
            }
        });
    }
}

package cn.maijinta.yunsenlin.view.fragment;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.UserManageActivity;
import cn.maijinta.yunsenlin.view.fragment.base.BaseFragment;

/**
 * Created by frank on 16/11/30.
 */

public class FinanceFragment extends BaseFragment {

    @BindView(R.id.cv_fin_7)
    CardView cv_fin_7;

    @OnClick(R.id.cv_fin_7) void showUser() {
        Intent intent_1 = new Intent(getActivity(), UserManageActivity.class);
        startActivity(intent_1);
    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.fragment_finance;
    }

    @Override
    protected void initPageView(View rootView) {

    }
}

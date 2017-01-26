package cn.maijinta.yunsenlin.view.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;
import cn.maijinta.yunsenlin.view.activity.base.OnItemClickListener;
import cn.maijinta.yunsenlin.view.adapter.CalculatorAdapter;

/**
 * Created by frank on 16/12/11.
 */

public class CalculatorActivity extends BaseActivity {

    @BindView(R.id.toolbar_calculator)
    Toolbar toolbar;

    @BindView(R.id.recyclerView_calculate)
    RecyclerView recyclerView;

    @BindView(R.id.tv_calculate_edit_1)
    TextView ed_1;

    @BindView(R.id.tv_calculate_edit_2)
    TextView ed_2;

    @BindView(R.id.tv_calculate_6)
    TextView tv_result;

    @BindView(R.id.iv_calculate_1)
    ImageView iv_1;

    @BindView(R.id.iv_calculate_2)
    ImageView iv_2;

    private boolean istop = true;

    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    private BigDecimal bd_result = new BigDecimal(0);

    @Override
    public int getLayoutId() {
        return R.layout.activity_calculator;
    }

    @Override
    protected void afterCreate() {
        initToolbar();
        initPageView();
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

    private void initPageView() {

        final List<String> cal_items = new ArrayList<>();
        cal_items.add("7");
        cal_items.add("8");
        cal_items.add("9");
        cal_items.add("X");
        cal_items.add("4");
        cal_items.add("5");
        cal_items.add("6");
        cal_items.add("up");
        cal_items.add("1");
        cal_items.add("2");
        cal_items.add("3");
        cal_items.add("down");
        cal_items.add("0");
        cal_items.add(".");
        cal_items.add("=");

        List<Integer> cal_drawables = new ArrayList<>();
        cal_drawables.add(R.drawable.up_cal);
        cal_drawables.add(R.drawable.down_cal);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        //每个item的宽度设置
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 14){
                    return 2;
                }else {
                    return 1;
                }
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        CalculatorAdapter calculatorAdapter = new CalculatorAdapter(this,cal_items,cal_drawables);
        recyclerView.setAdapter(calculatorAdapter);
        calculatorAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String ed_str_1 = ed_1.getText().toString();
                String ed_str_2 = ed_2.getText().toString();
                if (position != 7 && position != 11
                        && position != 3 && position != 14){
                    if (istop){
                        if (ed_str_1.equals("0")){
                            if (position == 13){
                                ed_1.setText("0"+cal_items.get(position));
                            }else {
                                ed_1.setText(cal_items.get(position));
                            }
                        }else {
                            ed_1.setText(ed_str_1+cal_items.get(position));
                        }
                    }else {
                        if (ed_str_2.equals("0")){
                            if (position == 13){
                                ed_2.setText("0"+cal_items.get(position));
                            }else {
                                ed_2.setText(cal_items.get(position));
                            }
                        }else {
                            ed_2.setText(ed_str_2+cal_items.get(position));
                        }
                    }
                }else if (position == 3){
                    if (istop){
                        ed_str_1 = ed_str_1.substring(0,ed_str_1.length()-1);
                        if (ed_str_1.isEmpty()||ed_str_1.equals("")){
                            ed_str_1 = "0";
                        }
                        ed_1.setText(ed_str_1);
                    }else {
                        ed_str_2 = ed_str_2.substring(0,ed_str_2.length()-1);
                        if (ed_str_2.isEmpty()||ed_str_2.equals("")){
                            ed_str_2 = "0";
                        }
                        ed_2.setText(ed_str_2);
                    }
                }else if (position == 14){
                    tv_result.setText(decimalFormat.format(bd_result.doubleValue()));
                    bd_result = bd_result.subtract(bd_result);
                }else if (position == 7){
                    istop = true;
                    iv_1.setVisibility(View.VISIBLE);
                    iv_2.setVisibility(View.GONE);
                }else if (position == 11){
                    istop = false;
                    iv_2.setVisibility(View.VISIBLE);
                    iv_1.setVisibility(View.GONE);
                }
            }
        });
    }


}

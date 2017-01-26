package cn.maijinta.yunsenlin.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.model.BondData;
import cn.maijinta.yunsenlin.view.activity.CalculatorActivity;

/**
 * Created by frank on 16/12/14.
 */

public class RecordAdapter extends SwipeMenuAdapter<RecordAdapter.RecordHolder> {

    private Activity activity;
    private List<BondData> bondDataList = new ArrayList<>();
    private List<RecordHolder> recordHolderList = new ArrayList<>();
    private boolean checkView_state = false;
    private boolean all_choose = false;

    public RecordAdapter(Activity activity,List<String> priceList) {
        this.activity = activity;
        for (String price : priceList){
            bondDataList.add(new BondData(price));
        }
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        RecordHolder recordHolder = new RecordHolder(view);
        recordHolderList.add(recordHolder);
        return view;
    }

    @Override
    public RecordHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new RecordHolder(realContentView);
    }

    @Override
    public void onBindViewHolder(RecordAdapter.RecordHolder holder, int position) {
        holder.textView.setText(bondDataList.get(position).getRecord());
        final BondData bondData = bondDataList.get(position);
        if (checkView_state){
            holder.checkBox.setVisibility(View.VISIBLE);
        }else {
            holder.checkBox.setVisibility(View.GONE);
        }

        holder.checkBox.setChecked(bondData.getChecked());


        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //物理变动更新到逻辑状态
                bondData.setChecked(isChecked);
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CalculatorActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bondDataList.size();
    }

    public void switchCheckView(RelativeLayout relativeLayout, MenuItem item, SwipeMenuRecyclerView swipeMenuRecyclerView){
        if (!checkView_state){
            relativeLayout.setVisibility(View.VISIBLE);
            item.setTitle("完成");
//            swipeMenuRecyclerView.setItemViewSwipeEnabled(false);
        }else {
            relativeLayout.setVisibility(View.GONE);
            item.setTitle("编辑");
//            swipeMenuRecyclerView.setItemViewSwipeEnabled(true);
        }
        checkView_state = !checkView_state;
        notifyDataSetChanged();//重新加载列表
    }

    public void chooseAll() {
        //逻辑状态改变
        for (BondData bondData : bondDataList){
            bondData.setChecked(!all_choose);
        }
        all_choose = !all_choose;
        notifyDataSetChanged();
    }

    public void deleteChoose() {
        for (int i = 0;i < bondDataList.size();i++){//逻辑列表永远是所有item
            if (bondDataList.get(i).getChecked()){
//                recordHolderList.remove(i);物理列表总不能加载所有item
                bondDataList.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeChanged(i,bondDataList.size());//从变化到尾更新总数
                i--;//抵消元素删去后位置重合
            }
        }
    }

    public void deletePosition(int position){
        bondDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,bondDataList.size());
    }

    class RecordHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_checkbox)
        CheckBox checkBox;

        @BindView(R.id.tv_item_record_4)
        TextView textView;

        RecordHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

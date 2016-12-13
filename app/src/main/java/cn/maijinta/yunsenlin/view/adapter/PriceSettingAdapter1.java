package cn.maijinta.yunsenlin.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.maijinta.yunsenlin.R;

/**
 * Created by frank on 16/12/13.
 */

public class PriceSettingAdapter1 extends RecyclerView.Adapter<PriceSettingAdapter1.PriceSettingHolder> {

    private List<String> length_list;
    private List<String> diameter_list;
    private List<String> price_list;
    private Activity activity;

    public PriceSettingAdapter1(List<String> length_list, List<String> diameter_list, List<String> price_list, Activity activity) {
        this.length_list = length_list;
        this.diameter_list = diameter_list;
        this.price_list = price_list;
        this.activity = activity;
    }

    @Override
    public PriceSettingAdapter1.PriceSettingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_price_1, parent, false);
        return new PriceSettingAdapter1.PriceSettingHolder(view);
    }

    @Override
    public void onBindViewHolder(PriceSettingAdapter1.PriceSettingHolder holder, int position) {
        holder.textView_1.setText(length_list.get(position));
        holder.textView_2.setText(diameter_list.get(position));
        holder.textView_3.setText(price_list.get(position));
    }

    @Override
    public int getItemCount() {
        return length_list.size();
    }

    public static class PriceSettingHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_tv_price_set_1)
        TextView textView_1;

        @BindView(R.id.item_tv_price_set_2)
        TextView textView_2;

        @BindView(R.id.item_tv_price_set_3)
        TextView textView_3;


        public PriceSettingHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

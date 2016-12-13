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

public class PriceSettingAdapter2 extends RecyclerView.Adapter<PriceSettingAdapter2.PriceSettingHolder> {

    private List<String> format_list;
    private List<String> price_list;
    private Activity activity;

    public PriceSettingAdapter2(List<String> format_list, List<String> price_list, Activity activity) {
        this.format_list = format_list;
        this.price_list = price_list;
        this.activity = activity;
    }

    @Override
    public PriceSettingAdapter2.PriceSettingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_price_2, parent, false);
        return new PriceSettingAdapter2.PriceSettingHolder(view);
    }

    @Override
    public void onBindViewHolder(PriceSettingAdapter2.PriceSettingHolder holder, int position) {
        holder.textView_1.setText(format_list.get(position));
        holder.textView_2.setText(price_list.get(position));
    }

    @Override
    public int getItemCount() {
        return format_list.size();
    }

    public static class PriceSettingHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_tv_price_set_4)
        TextView textView_1;

        @BindView(R.id.item_tv_price_set_5)
        TextView textView_2;


        public PriceSettingHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

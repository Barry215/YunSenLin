package cn.maijinta.yunsenlin.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.CalculatorActivity;
import cn.maijinta.yunsenlin.view.activity.PriceSettingActivity;

/**
 * Created by frank on 16/11/30.
 */

public class CalculateAdapter extends RecyclerView.Adapter<CalculateAdapter.CalculateHolder> {

    private List<String> titles;
    private List<Integer> drawableList;
    private Activity activity;

    public CalculateAdapter(List<String> titles, List<Integer> drawableList, Activity activity) {
        this.titles = titles;
        this.drawableList = drawableList;
        this.activity = activity;
    }

    @Override
    public CalculateAdapter.CalculateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calculate, parent, false);
        return new CalculateHolder(view);
    }

    @Override
    public void onBindViewHolder(CalculateAdapter.CalculateHolder holder, final int position) {
        holder.textView.setText(titles.get(position));
//        Glide.with(activity).load(drawableList.get(position)).into(holder.imageView);
        holder.imageView.setImageResource(drawableList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 6){
                    Intent intent_6 = new Intent(activity,PriceSettingActivity.class);
                    activity.startActivity(intent_6);
                }else {
                    Intent intent_1 = new Intent(activity,CalculatorActivity.class);
                    activity.startActivity(intent_1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class CalculateHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_calculate)
        TextView textView;
        @BindView(R.id.iv_calculate)
        ImageView imageView;

        public CalculateHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

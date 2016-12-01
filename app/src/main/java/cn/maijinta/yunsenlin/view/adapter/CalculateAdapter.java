package cn.maijinta.yunsenlin.view.adapter;

import android.app.Activity;
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

/**
 * Created by frank on 16/11/30.
 */

public class CalculateAdapter extends RecyclerView.Adapter<CalculateAdapter.CalculateHolder> {

    private List<String> titles;
    private Activity activity;

    public CalculateAdapter(List<String> titles, Activity activity) {
        this.titles = titles;
        this.activity = activity;
    }

    @Override
    public CalculateAdapter.CalculateHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calculate, parent, false);
        return new CalculateHolder(view);
    }

    @Override
    public void onBindViewHolder(CalculateAdapter.CalculateHolder holder, int position) {
        List<Integer> drawableList = new ArrayList<>();
        drawableList.add(R.drawable.calculate_1);
        drawableList.add(R.drawable.calculate_2);
        drawableList.add(R.drawable.calculate_3);
        drawableList.add(R.drawable.calculate_4);
        drawableList.add(R.drawable.calculate_5);
        drawableList.add(R.drawable.calculate_6);
        drawableList.add(R.drawable.calculate_7);
        drawableList.add(R.drawable.calculate_8);
        drawableList.add(R.drawable.calculate_9);
        holder.textView.setText(titles.get(position));
//        Glide.with(activity).load(drawableList.get(position)).into(holder.imageView);
        holder.imageView.setImageResource(drawableList.get(position));
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

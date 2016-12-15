package cn.maijinta.yunsenlin.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.OnItemClickListener;

/**
 * Created by frank on 16/12/12.
 */

public class CalculatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private List<String> cal_items;
    private List<Integer> cal_drawables;

    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public CalculatorAdapter(Activity activity, List<String> cal_items, List<Integer> cal_drawables) {
        this.activity = activity;
        this.cal_items = cal_items;
        this.cal_drawables = cal_drawables;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_calculator, parent, false);
            return new CalculatorHolder_tv(view);
        }else if(viewType == 1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_iv_calculator, parent, false);
            return new CalculatorHolder_iv(view);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof CalculatorHolder_tv){
            ((CalculatorHolder_tv) holder).textView.setText(cal_items.get(position));
            if (position == 14){
                holder.itemView.setBackground(activity.getResources().getDrawable(R.drawable.item_iv_selector));
            }
            if (onItemClickListener != null){
                ((CalculatorHolder_tv) holder).textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(view,position);
                    }
                });
            }
        }else if (holder instanceof CalculatorHolder_iv){
            if (position == 7){
                ((CalculatorHolder_iv) holder).imageView.setImageDrawable(activity.getDrawable(cal_drawables.get(0)));
            }else {
                ((CalculatorHolder_iv) holder).imageView.setImageDrawable(activity.getDrawable(cal_drawables.get(1)));
            }
            if (onItemClickListener != null){
                ((CalculatorHolder_iv) holder).imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(view,position);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return cal_items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 7 || position == 11){
            return 1;
        }else {
            return 0;
        }
    }


    public static class CalculatorHolder_tv extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_calculator)
        TextView textView;

        public CalculatorHolder_tv(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class CalculatorHolder_iv extends RecyclerView.ViewHolder {
        @BindView(R.id.item_iv_calculator)
        ImageView imageView;

        public CalculatorHolder_iv(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

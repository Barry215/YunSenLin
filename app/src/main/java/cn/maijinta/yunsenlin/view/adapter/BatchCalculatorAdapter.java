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
 * Created by frank on 17/1/24.
 */

public class BatchCalculatorAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Activity activity;
    private List<String> cal_items;
    private List<Integer> cal_drawables;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public BatchCalculatorAdapter(Activity activity, List<String> cal_items, List<Integer> cal_drawables) {
        this.activity = activity;
        this.cal_items = cal_items;
        this.cal_drawables = cal_drawables;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_batch_calculator, parent, false);
            return new BatchCalculatorAdapter.BatchCalculatorHolder_tv(view);
        }else if(viewType == 1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_iv_batch_calculator, parent, false);
            return new BatchCalculatorAdapter.BatchCalculatorHolder_iv(view);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof BatchCalculatorAdapter.BatchCalculatorHolder_tv){
            ((BatchCalculatorAdapter.BatchCalculatorHolder_tv) holder).textView.setText(cal_items.get(position));
            if (position == 14){
                holder.itemView.setBackground(activity.getResources().getDrawable(R.drawable.item_iv_selector));
            }
            if (onItemClickListener != null){
                ((BatchCalculatorAdapter.BatchCalculatorHolder_tv) holder).textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(view,holder.getAdapterPosition());
                    }
                });
            }
        }else if (holder instanceof BatchCalculatorAdapter.BatchCalculatorHolder_iv){
            if (position == 7){
                ((BatchCalculatorAdapter.BatchCalculatorHolder_iv) holder).imageView.setImageDrawable(activity.getDrawable(cal_drawables.get(0)));
            }else {
                ((BatchCalculatorAdapter.BatchCalculatorHolder_iv) holder).imageView.setImageDrawable(activity.getDrawable(cal_drawables.get(1)));
            }
            if (onItemClickListener != null){
                ((BatchCalculatorAdapter.BatchCalculatorHolder_iv) holder).imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(view,holder.getAdapterPosition());
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

    public static class BatchCalculatorHolder_tv extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_batch_calculator)
        TextView textView;

        public BatchCalculatorHolder_tv(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class BatchCalculatorHolder_iv extends RecyclerView.ViewHolder {
        @BindView(R.id.item_iv_batch_calculator)
        ImageView imageView;

        public BatchCalculatorHolder_iv(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}

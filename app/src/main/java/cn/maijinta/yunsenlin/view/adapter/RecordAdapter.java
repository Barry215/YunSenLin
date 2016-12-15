package cn.maijinta.yunsenlin.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.maijinta.yunsenlin.R;

/**
 * Created by frank on 16/12/14.
 */

public class RecordAdapter extends SwipeMenuAdapter<RecordAdapter.RecordHolder> {

    private Activity activity;
    private List<String> priceList;
    private List<RecordHolder> recordHolderList = new ArrayList<>();
    private static boolean checkView_state = false;

    public RecordAdapter(Activity activity,List<String> priceList) {
        this.activity = activity;
        this.priceList = priceList;
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
        holder.textView.setText(priceList.get(position));
    }

    @Override
    public int getItemCount() {
        return priceList.size();
    }

    public void switchCheckView(RelativeLayout relativeLayout, MenuItem item, SwipeMenuRecyclerView swipeMenuRecyclerView){
        if (!checkView_state){
            showCheckView();
            relativeLayout.setVisibility(View.VISIBLE);
            item.setTitle("完成");
//            swipeMenuRecyclerView.setItemViewSwipeEnabled(false);
        }else {
            hideCheckView();
            relativeLayout.setVisibility(View.GONE);
            item.setTitle("编辑");
//            swipeMenuRecyclerView.setItemViewSwipeEnabled(true);
        }
    }

    public void showCheckView(){
        for (RecordHolder recordHolder : recordHolderList){
            recordHolder.openCheckView();
        }
        checkView_state = true;
    }

    public void hideCheckView(){
        for (RecordHolder recordHolder : recordHolderList){
            recordHolder.closeCheckView();
        }
        checkView_state = false;
    }

    public class RecordHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_checkbox)
        CheckBox checkBox;

        @BindView(R.id.tv_item_record_4)
        TextView textView;

        public void openCheckView(){
            checkBox.setVisibility(View.VISIBLE);
        }

        public void closeCheckView(){
            checkBox.setVisibility(View.GONE);
        }

        public RecordHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

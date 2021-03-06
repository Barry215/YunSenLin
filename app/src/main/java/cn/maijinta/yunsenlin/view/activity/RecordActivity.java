package cn.maijinta.yunsenlin.view.activity;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maijinta.yunsenlin.R;
import cn.maijinta.yunsenlin.view.activity.base.BaseActivity;
import cn.maijinta.yunsenlin.view.adapter.RecordAdapter;
import cn.maijinta.yunsenlin.view.ui.DividerLine;

/**
 * Created by frank on 16/12/14.
 */

public class RecordActivity extends BaseActivity {

    @BindView(R.id.toolbar_record)
    Toolbar toolbar;

    @BindView(R.id.recycler_record)
    SwipeMenuRecyclerView swipeMenuRecyclerView;

    @BindView(R.id.relative_layout_record)
    RelativeLayout relativeLayout;

    @BindView(R.id.tv_record_1)
    TextView tv_all;

    @BindView(R.id.tv_record_2)
    TextView tv_del;

    @OnClick(R.id.tv_record_1) void click_choose_all() {
        recordAdapter.chooseAll();
    }

    @OnClick(R.id.tv_record_2) void click_del() {
        recordAdapter.deleteChoose();
    }

    private Activity mContext;
    private List<String> priceList;
    private RecordAdapter recordAdapter;


    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int width = getResources().getDimensionPixelSize(R.dimen.item_width);

            // MATCH_PARENT 自适应高度，保持和内容一样高；也可以指定菜单具体高度，也可以用WRAP_CONTENT。
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
//            int height = getResources().getDimensionPixelSize(R.dimen.item_height);

            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(mContext)
                        .setBackgroundColor(Color.RED)
                        .setText("删除")
                        .setTextSize(18)
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(deleteItem);// 添加一个按钮到右侧侧菜单。
            }
        }
    };

    private OnSwipeMenuItemClickListener menuItemClickListener = new OnSwipeMenuItemClickListener() {
        @Override
        public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {
            if (menuPosition == 0) {// 删除按钮被点击。
                recordAdapter.deletePosition(adapterPosition);
            }
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_record;
    }

    @Override
    protected void afterCreate() {
        mContext = this;
        initToolbar();
        initPageView();

    }

    private void initPageView() {
        priceList = new ArrayList<>();
        priceList.add("0.855");
        priceList.add("1.855");
        priceList.add("2.855");
        priceList.add("3.855");
        priceList.add("4.855");
        priceList.add("5.855");
        priceList.add("6.850");
        priceList.add("7.835");
        priceList.add("8.865");
        priceList.add("9.875");


        //后期再试试自定义的滑动删除，或者找其他的库
        recordAdapter = new RecordAdapter(this,priceList);
        swipeMenuRecyclerView.setLayoutManager(new LinearLayoutManager(swipeMenuRecyclerView.getContext()));
        swipeMenuRecyclerView.setSwipeMenuCreator(swipeMenuCreator);
        swipeMenuRecyclerView.setSwipeMenuItemClickListener(menuItemClickListener);
        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(1);
        dividerLine.setColor(getResources().getColor(R.color.GRAY));
        swipeMenuRecyclerView.addItemDecoration(dividerLine);
        swipeMenuRecyclerView.setAdapter(recordAdapter);

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

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_edit){
                    recordAdapter.switchCheckView(relativeLayout,item,swipeMenuRecyclerView);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }
}

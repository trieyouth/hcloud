package com.zero.hcloud.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.views.ProgressBarCircularIndeterminate;
import com.zero.hcloud.R;
import com.zero.hcloud.adapter.GeneralAdapter;
import com.zero.hcloud.model.bean.Post;
import com.zero.hcloud.model.bean.User;
import com.zero.hcloud.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by youth on 2015/11/16.
 */
public class GeneralFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    private LinearLayoutManager mLayoutManager;
    private GeneralAdapter adapter;
    private int lastVisibleItem;

    protected static final int ORI_PAGE = 1;
    protected int page = ORI_PAGE + 1;


    @InjectView(R.id.fragment_general_list)
    RecyclerView mRecyclerView;

    @InjectView(R.id.fragment_general_swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshWidget;

    @InjectView(R.id.fragment_general_progressbar)
    ProgressBarCircularIndeterminate mProgressBar;

    @InjectView(R.id.fragment_general_error)
    View mError;

    @InjectView(R.id.fragment_general_error_info)
    TextView mErrortext;

    @InjectView(R.id.fragment_general_reload)
    ButtonRectangle mErrorb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getCententView(inflater, R.layout.fragment_general);
        ButterKnife.inject(this, view);
        init();
        initErrorFrag();
        return view;
    }


    private void init() {
        mSwipeRefreshWidget.setColorSchemeColors(R.color.abc_background_cache_hint_selector_material_dark);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    requestData(page++, 1);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new GeneralAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
        requestData(ORI_PAGE, 0);
    }

    private void error(String text) {
        visibleError();
        goneProgressbar();
        goneRecycleView();
        mErrortext.setText(text);
    }

    private void initErrorFrag() {

        mErrorb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                visibleProgressbar();
                goneError();
                requestData(ORI_PAGE, 0);
            }

        });
    }

    public void visibleRecycleView() {
        if (mRecyclerView != null) {
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    public void goneRecycleView() {
        if (mRecyclerView != null) {
            mRecyclerView.setVisibility(View.GONE);
        }
    }

    public void visibleProgressbar() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    public void goneProgressbar() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    public void visibleError() {
        if (mError != null) {
            mError.setVisibility(View.VISIBLE);
        }
    }

    public void goneError() {
        if (mError != null) {
            mError.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        if (mRecyclerView.getVisibility() != View.GONE) {
            requestData(ORI_PAGE, 0);
        }
    }

    private void requestData(int page, final int what) {
        if (what == 0) {
            adapter.clearAll();
            mSwipeRefreshWidget.setRefreshing(false);
        }
        if (mRecyclerView.getVisibility() == View.GONE) {
            visibleRecycleView();
            goneProgressbar();
            goneError();
        }
        adapter.add(getData());
    }

    private List<Post> getData() {
        ArrayList<Post> list = new ArrayList();

//        Post post = new Post();
//        post.content = "我的钱包掉在了5栋篮球场,棕色的，里面有身份证，求送还，电话：18883448592。";
//        post.time = "2016-05-31  13:50";
//        post.money = "金额： 1元";
//        User user = new User();
//        user.avatar = R.drawable.defaultman;
//        user.name = "trieyouth";
//        post.user = user;
//        list.add(post);
//
//        Post post1 = new Post();
//        User user1 = new User();
//        post1.content = "我的书包掉在了二教，阿迪蓝色，电话：18883801784。必有重谢";
//        post1.time = "2015-05-30  15:50";
//        post1.money = "金额： 5元";
//        user1.avatar = R.drawable.a;
//        user1.name = "郭金明";
//        post1.user = user1;
//        list.add(post1);
//
//        Post post2 = new Post();
//        User user2 = new User();
//        post2.content = "我的伞不见了，一个黑色的折叠伞，朋友送的，意义重大，电话：18886945492，有重谢";
//        post2.time = "2015-05-22  09:50";
//        post2.money = "金额： 5元";
//        user2.avatar = R.drawable.b;
//        user2.name = "王超凡";
//        post2.user = user2;
//        list.add(post2);
//
//        Post post3 = new Post();
//        User user3 = new User();
//        post3.content = "今天回到寝室发现身份证不见了，姓名是杨勇，电话：18883283223";
//        post3.time = "2015-05-22  09:50";
//        post3.money = "金额： 2元";
//        user3.avatar = R.drawable.c;
//        user3.name = "杨勇";
//        post3.user = user3;
//        list.add(post3);
        Post post = new Post();
        post.content = "快递到了，韵达快递，可以帮忙的私聊，电话：18883993592。";
        post.time = "2016-06-01  10:50";
        post.money = "金额： 1元";
        User user = new User();
        user.avatar = R.drawable.d;
        user.name = "王志";
        post.user = user;
        list.add(post);

        Post post1 = new Post();
        User user1 = new User();
        post1.content = "快递到了，5栋楼下，可以帮忙的私聊，QQ：489390345。";
        post1.time = "2015-05-28  04:50";
        post1.money = "金额： 1元";
        user1.avatar = R.drawable.e;
        user1.name = "徐折原";
        post1.user = user1;
        list.add(post1);

        Post post2 = new Post();
        User user2 = new User();
        post2.content = "快递到了，韵达快递，可以帮忙的私聊，QQ：437834324。";
        post2.time = "2015-05-23  11:50";
        post2.money = "金额： 3元";
        user2.avatar = R.drawable.g;
        user2.name = "憨豆";
        post2.user = user2;
        list.add(post2);

        Post post3 = new Post();
        User user3 = new User();
        post3.content = "今天回到寝室发现身份证不见了，姓名是杨勇，QQ：969058495";
        post3.time = "2015-05-22  13:50";
        post3.money = "金额： 2元";
        user3.avatar = R.drawable.f;
        user3.name = "黄胜";
        post3.user = user3;
        list.add(post3);
        return list;
    }
}

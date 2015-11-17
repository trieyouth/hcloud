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
public class GeneralFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{


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


    private void init(){
        mSwipeRefreshWidget.setColorSchemeColors(R.color.abc_background_cache_hint_selector_material_dark);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    requestData(page++,1);
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

        adapter = new GeneralAdapter();
        mRecyclerView.setAdapter(adapter);
        requestData(ORI_PAGE, 0);
    }

    private void error(String text) {
        visibleError();
        goneProgressbar();
        goneRecycleView();
        mErrortext.setText(text);
    }

    private void initErrorFrag(){

        mErrorb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                visibleProgressbar();
                goneError();
                requestData(ORI_PAGE, 0);
            }

        });
    }

    public void visibleRecycleView(){
        if(mRecyclerView!=null){
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    public void goneRecycleView(){
        if(mRecyclerView!=null){
            mRecyclerView.setVisibility(View.GONE);
        }
    }

    public void visibleProgressbar(){
        if(mProgressBar!=null){
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    public void goneProgressbar(){
        if(mProgressBar!=null){
            mProgressBar.setVisibility(View.GONE);
        }
    }

    public void visibleError(){
        if(mError!=null){
            mError.setVisibility(View.VISIBLE);
        }
    }

    public void goneError(){
        if(mError!=null){
            mError.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        if(mRecyclerView.getVisibility() != View.GONE){
            requestData(ORI_PAGE, 0);
        }
    }

    private void requestData(int page , final int what){
        if(what == 0){
            adapter.clearAll();
            mSwipeRefreshWidget.setRefreshing(false);
        }
        if(mRecyclerView.getVisibility() == View.GONE){
            visibleRecycleView();
            goneProgressbar();
            goneError();
        }
        adapter.add(getData());
    }

    private List<Post> getData(){
        ArrayList<Post> list = new ArrayList();
        Post post = new Post();
        post.content = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        post.time = "2015-11-17  13:50";
        for(int i=0;i<10;i++){
            list.add(post);
        }
        return list;
    }
}

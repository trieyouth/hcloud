package com.zero.hcloud.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gc.materialdesign.views.ButtonRectangle;
import com.zero.hcloud.R;
import com.zero.hcloud.model.bean.Post;

import org.w3c.dom.Comment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by youth on 2015/11/17.
 */
public class GeneralAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Post> list;

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private View footer;

    public List<Post> getList() {
        return list;
    }

    public GeneralAdapter() {
        list = new ArrayList<Post>();
    }

    public void clearAll(){
        list.clear();
        notifyDataSetChanged();
    }

    public void add(List<Post> _list){
        list.addAll(_list);
    }

    public void add(Post[] comments){
        for(Post comment:comments){
            list.add(comment);
        }
        notifyDataSetChanged();
    }

    public void error(){
        if(footer != null){
            footer.findViewById(R.id._b).setVisibility(View.VISIBLE);
            footer.findViewById(R.id._error_info).setVisibility(View.VISIBLE);
            footer.findViewById(R.id.progressbar).setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder _holder = ((ViewHolder) holder);

        } else if(holder instanceof FooterViewHolder){
            FooterViewHolder _holder = ((FooterViewHolder) holder);
            footer =  _holder.root;
            footer.findViewById(R.id._b).setVisibility(View.GONE);
            footer.findViewById(R.id._error_info).setVisibility(View.GONE);
            ((ButtonRectangle)footer.findViewById(R.id._b)).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    footer.findViewById(R.id._b).setVisibility(View.GONE);
                    footer.findViewById(R.id._error_info).setVisibility(View.GONE);
                    footer.findViewById(R.id.progressbar).setVisibility(View.VISIBLE);
                }

            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_general, parent, false);
            return new ViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_footerview, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
        return null;
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public View root;

        public FooterViewHolder(View view) {
            super(view);
            root = view;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;


        public ViewHolder(View view) {
            super(view);
            mView = view;

        }
    }

}

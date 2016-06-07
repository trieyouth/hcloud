package com.zero.hcloud.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.zero.hcloud.R;
import com.zero.hcloud.model.bean.Post;

import org.w3c.dom.Comment;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by youth on 2015/11/17.
 */
public class GeneralAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Post> list;

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private View footer;

    private Context context;

    public List<Post> getList() {
        return list;
    }

    public GeneralAdapter(Context context) {
        list = new ArrayList<Post>();
        this.context = context;
    }

    public void clearAll(){
        list.clear();
        notifyDataSetChanged();
    }

    public void add(List<Post> _list){
        for(int i=0;i<_list.size();i++){
            list.add(_list.get(i));
        }
        notifyDataSetChanged();
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
            if(position<list.size()){
                Picasso.with(context).load(list.get(position).user.avatar).into(_holder.head);
                _holder.head.setImageResource(list.get(position).user.avatar);
                _holder.name.setText(list.get(position).user.name);
                _holder.text.setText(list.get(position).content);
                _holder.money.setText(list.get(position).money);
            }
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

        public CircularImageView head;
        public TextView text;
        public TextView time;
        public TextView money;
        public TextView name;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            head = (CircularImageView) view.findViewById(R.id.head);
            text = (TextView) view.findViewById(R.id.text);
            time = (TextView) view.findViewById(R.id.time);
            name = (TextView) view.findViewById(R.id.name);
            money = (TextView) view.findViewById(R.id.money);
        }
    }

}

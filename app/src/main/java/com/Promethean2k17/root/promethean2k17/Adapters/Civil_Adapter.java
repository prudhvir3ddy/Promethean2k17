package com.Promethean2k17.root.promethean2k17.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.Promethean2k17.root.promethean2k17.Models.Civil_Model;
import com.Promethean2k17.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 15/9/17.
 */

public class Civil_Adapter extends RecyclerView.Adapter<Civil_Adapter.CivilViewHolder>  {
    private List<Civil_Model> arraylist;
    private Context context;
    public Civil_Adapter(List<Civil_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Civil_Adapter.CivilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new Civil_Adapter.CivilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Civil_Adapter.CivilViewHolder holder, int position) {
        Civil_Model model=arraylist.get(position);
        Glide.with(context).load(model.getCivil_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(android.R.drawable.ic_dialog_alert).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.Civil_pic);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class CivilViewHolder extends RecyclerView.ViewHolder{
        ImageView Civil_pic;
        ProgressBar progressBar;
        public CivilViewHolder(View itemView) {
            super(itemView);
            Civil_pic = itemView.findViewById(R.id.home_imgview);
            progressBar= itemView.findViewById(R.id.progress);
        }
    }
}

package com.example.root.promethean2k17.Adapters;

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
import com.example.root.promethean2k17.Models.Phe_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 15/9/17.
 */

public class Phe_Adapter extends RecyclerView.Adapter<Phe_Adapter.PheViewHolder>{
    private List<Phe_Model> arraylist;
    private Context context;
    public Phe_Adapter(List<Phe_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Phe_Adapter.PheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new Phe_Adapter.PheViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Phe_Adapter.PheViewHolder holder, int position) {
        Phe_Model model=arraylist.get(position);
        Glide.with(context).load(model.getPhe_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(android.R.drawable.ic_dialog_alert).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.Phe_pic);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class PheViewHolder extends RecyclerView.ViewHolder{
        ImageView Phe_pic;
        ProgressBar progressBar;
        public PheViewHolder(View itemView) {
            super(itemView);
            Phe_pic = itemView.findViewById(R.id.home_imgview);
            progressBar= itemView.findViewById(R.id.progress);
        }
    }
}

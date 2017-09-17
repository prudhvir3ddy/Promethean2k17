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
import com.example.root.promethean2k17.Models.Bme_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 15/9/17.
 */

public class Bme_Adapter extends RecyclerView.Adapter<Bme_Adapter.BmeViewHolder>{
    private List<Bme_Model> arraylist;
    private Context context;
    public Bme_Adapter(List<Bme_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Bme_Adapter.BmeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new Bme_Adapter.BmeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Bme_Adapter.BmeViewHolder holder, int position) {
        Bme_Model model=arraylist.get(position);
        Glide.with(context).load(model.getBme_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.ic_error).into(holder.Bme_pic);
        holder.progressBar.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class BmeViewHolder extends RecyclerView.ViewHolder{
        ImageView Bme_pic;
        ProgressBar progressBar;
        public BmeViewHolder(View itemView) {
            super(itemView);
            Bme_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}
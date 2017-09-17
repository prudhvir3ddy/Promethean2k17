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
import com.example.root.promethean2k17.Models.Civil_Model;
import com.example.root.promethean2k17.R;

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
    public void onBindViewHolder(Civil_Adapter.CivilViewHolder holder, int position) {
        Civil_Model model=arraylist.get(position);
        Glide.with(context).load(model.getCivil_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.ic_error).into(holder.Civil_pic);
        holder.progressBar.setVisibility(View.GONE);
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
            Civil_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}

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

import com.example.root.promethean2k17.Models.Ece_Model;

import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 14/9/17.
 */

public class Ece_Adapter  extends RecyclerView.Adapter<Ece_Adapter.EceViewHolder>{
    private List<Ece_Model> arraylist;
    private Context context;
    public Ece_Adapter(List<Ece_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;

    }
    @Override
    public Ece_Adapter.EceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new Ece_Adapter.EceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Ece_Adapter.EceViewHolder holder, int position) {
        Ece_Model model=arraylist.get(position);
        Glide.with(context).load(model.getEce_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.ic_error).into(holder.Ece_pic);
        holder.progressBar.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class EceViewHolder extends RecyclerView.ViewHolder{
        ImageView Ece_pic;
        ProgressBar progressBar;
        public EceViewHolder(View itemView) {
            super(itemView);
            Ece_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}

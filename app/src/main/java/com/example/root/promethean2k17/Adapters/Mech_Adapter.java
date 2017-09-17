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

import com.example.root.promethean2k17.Models.Mech_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 14/9/17.
 */

public class Mech_Adapter extends RecyclerView.Adapter<Mech_Adapter.MechViewHolder> {
    private List<Mech_Model> arraylist;
    private Context context;
    public Mech_Adapter(List<Mech_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Mech_Adapter.MechViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new Mech_Adapter.MechViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Mech_Adapter.MechViewHolder holder, int position) {
        Mech_Model model=arraylist.get(position);
        Glide.with(context).load(model.getMech_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.ic_error).into(holder.Mech_pic);
        holder.progressBar.setVisibility(View.GONE);

    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class MechViewHolder extends RecyclerView.ViewHolder{
        ImageView Mech_pic;
        ProgressBar progressBar;
        public MechViewHolder(View itemView) {
            super(itemView);
            Mech_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}

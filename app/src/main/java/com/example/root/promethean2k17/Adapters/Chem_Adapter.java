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
import com.example.root.promethean2k17.Models.Chem_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 15/9/17.
 */

public class Chem_Adapter extends RecyclerView.Adapter<Chem_Adapter.ChemViewHolder>{
    private List<Chem_Model> arraylist;
    private Context context;
    public Chem_Adapter(List<Chem_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Chem_Adapter.ChemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new Chem_Adapter.ChemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Chem_Adapter.ChemViewHolder holder, int position) {
        Chem_Model model=arraylist.get(position);
        Glide.with(context).load(model.getChem_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.ic_error).into(holder.Chem_pic);
        holder.progressBar.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class ChemViewHolder extends RecyclerView.ViewHolder{
        ImageView Chem_pic;
        ProgressBar progressBar;
        public ChemViewHolder(View itemView) {
            super(itemView);
            Chem_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}

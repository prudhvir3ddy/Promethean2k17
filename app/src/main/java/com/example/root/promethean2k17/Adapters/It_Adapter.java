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
import com.example.root.promethean2k17.Models.It_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 15/9/17.
 */

public class It_Adapter extends RecyclerView.Adapter<It_Adapter.ItViewHolder>{
    private List<It_Model> arraylist;
    private Context context;
    public It_Adapter(List<It_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public It_Adapter.ItViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new It_Adapter.ItViewHolder(v);
    }

    @Override
    public void onBindViewHolder(It_Adapter.ItViewHolder holder, int position) {
        It_Model model=arraylist.get(position);
        Glide.with(context).load(model.getIt_pic()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.ic_error).into(holder.It_pic);
        holder.progressBar.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class ItViewHolder extends RecyclerView.ViewHolder{
        ImageView It_pic;
        ProgressBar progressBar;
        public ItViewHolder(View itemView) {
            super(itemView);
            It_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}

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
import com.bumptech.glide.request.RequestOptions;
import com.example.root.promethean2k17.Activities.Cse;
import com.example.root.promethean2k17.Models.Cse_Model;
import com.example.root.promethean2k17.Models.Home_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 14/9/17.
 */

public class Cse_Adapter extends RecyclerView.Adapter<Cse_Adapter.CseViewHolder>{
private List<Cse_Model> arraylist;
    private Context context;
    public Cse_Adapter(List<Cse_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Cse_Adapter.CseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new CseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CseViewHolder holder, int position) {
        Cse_Model model=arraylist.get(position);
        RequestOptions req = new RequestOptions();
        req.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        req.error(R.drawable.ic_error);
        Glide.with(context)
                .load(model.getCse_pic())
                .apply(req)
                .into(holder.Cse_pic);

        holder.progressBar.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class CseViewHolder extends RecyclerView.ViewHolder{
        ImageView Cse_pic;
        ProgressBar progressBar;
        public CseViewHolder(View itemView) {
            super(itemView);
            Cse_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}

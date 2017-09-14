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
import com.example.root.promethean2k17.Models.Home_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 12/9/17.
 */

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.HomeViewHolder>{
    private List<Home_Model> arraylist;
    private Context context;

    public Home_Adapter(List<Home_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Home_Adapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new HomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Home_Adapter.HomeViewHolder holder, int position) {
        Home_Model model = arraylist.get(position);
        RequestOptions req = new RequestOptions();
        req.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        req.error(R.drawable.ic_error);
        Glide.with(context)
                .load(model.getCat_pic())
                .apply(req)
                .into(holder.cat_img);

        holder.progressBar.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView cat_img;
        ProgressBar progressBar;

        public HomeViewHolder(View itemView) {
            super(itemView);
            cat_img = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }

    }
}

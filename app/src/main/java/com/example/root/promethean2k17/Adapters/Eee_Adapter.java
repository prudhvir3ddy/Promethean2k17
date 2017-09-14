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
import com.example.root.promethean2k17.Models.Eee_Model;
import com.example.root.promethean2k17.R;

import java.util.List;

public class Eee_Adapter extends RecyclerView.Adapter<Eee_Adapter.EeeViewHolder>{
    private List<Eee_Model> arraylist;
    private Context context;
    public Eee_Adapter(List<Eee_Model> arraylist, Context context){
        this.arraylist = arraylist;
        this.context = context;
    }
    @Override
    public Eee_Adapter.EeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_listmodel, parent, false);
        return new EeeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EeeViewHolder holder, int position) {
        Eee_Model model=arraylist.get(position);
        RequestOptions req = new RequestOptions();
        req.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        req.error(R.drawable.ic_error);
        Glide.with(context)
                .load(model.getEee_pic())
                .apply(req)
                .into(holder.Eee_pic);

        holder.progressBar.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return arraylist.size();
    }
    public static class EeeViewHolder extends RecyclerView.ViewHolder{
        ImageView Eee_pic;
        ProgressBar progressBar;
        public EeeViewHolder(View itemView) {
            super(itemView);
            Eee_pic = (ImageView) itemView.findViewById(R.id.home_imgview);
            progressBar= (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }
}

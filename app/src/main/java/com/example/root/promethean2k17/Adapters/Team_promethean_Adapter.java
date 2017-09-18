package com.example.root.promethean2k17.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.root.promethean2k17.Models.Team_promethean_Model;
import com.example.root.promethean2k17.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

/**
 * Created by root on 15/9/17.
 */

public class Team_promethean_Adapter extends RecyclerView.Adapter<Team_promethean_Adapter.Team_prometheanViewHolder> {
    List<Team_promethean_Model> list;
    Context context;

    public Team_promethean_Adapter(List<Team_promethean_Model> list, Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public Team_prometheanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_promethean_model, parent, false);
        return new Team_prometheanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Team_prometheanViewHolder holder, int position) {
        Team_promethean_Model model = list.get(position);
        holder.name.setText(String.valueOf(model.getTeam_promethean_Name()));
        Glide.with(context).load(model.getTeam_promethean_Image()).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(android.R.drawable.ic_dialog_alert).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Team_prometheanViewHolder extends RecyclerView.ViewHolder {

        CircularImageView image;
        TextView name;
        ProgressBar progressBar;
        public Team_prometheanViewHolder(View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.team_promethean_img);
            name= itemView.findViewById(R.id.team_promethean_name);
            progressBar= itemView.findViewById(R.id.progress);
        }
    }


}

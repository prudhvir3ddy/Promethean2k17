package com.Promethean2k17.root.promethean2k17.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.Promethean2k17.root.promethean2k17.Models.Registered_Events_Model;
import com.Promethean2k17.root.promethean2k17.R;

import java.util.List;

/**
 * Created by root on 16/9/17.
 */

public class Registered_Event_Adapter extends RecyclerView.Adapter<Registered_Event_Adapter.RegEvent_ViewHolder> {
    List<Registered_Events_Model> list;
    Context context;


    public Registered_Event_Adapter(List<Registered_Events_Model> list, Context context){
        this.list=list;
        this.context=context;
        Log.d("listsize:",""+list.size());
    }

    @Override
    public RegEvent_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.registered_event_model, parent, false);
        RegEvent_ViewHolder regEvent_viewHolder=new RegEvent_ViewHolder(v);
        return  regEvent_viewHolder;
    }

    @Override
    public void onBindViewHolder(RegEvent_ViewHolder holder, int position) {
        Registered_Events_Model model = list.get(position);
        holder.eventname.setText(String.valueOf(model.getEventname()));
        holder.event_reg_id.setText(String.valueOf(model.getEvent_reg_id()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RegEvent_ViewHolder extends RecyclerView.ViewHolder {

        TextView eventname;
        TextView event_reg_id;
        public RegEvent_ViewHolder(View itemView) {
            super(itemView);
            eventname= itemView.findViewById(R.id.eventname);
            event_reg_id= itemView.findViewById(R.id.event_reg_id);

//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    TextView e_name = (TextView) view.findViewById(R.id.eventname);
//                    final TextView e_id = (TextView) view.findViewById(R.id.event_reg_id);
//                    final String eventname=e_name.getText().toString();
//                    final String eventid=e_id.getText().toString();
//                    Log.d("LOG","LONGGGG"+eventname);
//
//
//
//                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
//
//
//                    alertDialog.setTitle("Confirm Delete...");
//
//
//                    alertDialog.setMessage("Are you sure you want delete this? \n" +
//                            "NOTE: If you have already made the payment for this event and you still delete it without attending,You cannot attend the event and Money wont be Refunded.");
//
//
//                    alertDialog.setIcon(R.drawable.promethean);
//
//
//                    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog,int which) {
//                            Intent i = new Intent(context, Delete_Event.class);
//                            i.putExtra("eventname",eventname);
//                            i.putExtra("eventid",eventid);
//                            context.startActivity(i);
//
//                        }
//                    });
//                    alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.cancel();
//                        }
//                    });
//                    alertDialog.show();
//
//                    return false;
//                }
//            });
//

        }
    }

}

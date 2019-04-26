package com.manjitborah.magnumsolutions;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.manjitborah.magnumsolutions.model.Message;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class RVAdapter extends RecyclerView.Adapter {
    Context context;
    List<Message> data;
    MainActivity activity;
    public RVAdapter(Context context,List<Message> data,Activity callingActivity) {
        this.context=context;
        this.data=data;
        this.activity=(MainActivity) callingActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.messages_view,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(view,context);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Message message=data.get(i);
        MyViewHolder myViewHolder=(MyViewHolder) viewHolder;
        myViewHolder.setMessage(message.getMsg(),message.getTime(),message.getType(),message.getSendOrReceive());
        myViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.addNewRandomMessages();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder {

    TextView msg;
    TextView time_tv;
    ImageView img;
    LinearLayout layout;
    LinearLayout parentLayout;
    Context context;
    public MyViewHolder(@NonNull View itemView, final Context context) {
        super(itemView);
        this.context=context;
        msg=itemView.findViewById(R.id.msg);
        time_tv=itemView.findViewById(R.id.time_v);
        img=itemView.findViewById(R.id.img);
        layout=itemView.findViewById(R.id.layout);
        parentLayout=itemView.findViewById(R.id.parentLayout);


    }


    public void setMessage(String msgOrUrl,String time,int type,int sentOrReceived){
        if(type==Message.TYPE_TEXT){
            img.setVisibility(View.GONE);
            msg.setVisibility(View.VISIBLE);
            msg.setText(msgOrUrl);
        }
        else if(type==Message.TYPE_IMAGE){
            msg.setVisibility(View.GONE);
            img.setVisibility(View.VISIBLE);
            Glide.with(context).load(context.getResources().getDrawable(R.drawable.example_img)).into(this.img);
        }
        time_tv.setText(time);
        if(sentOrReceived==Message.SEND){
            parentLayout.setGravity(Gravity.RIGHT);
            layout.setBackground(context.getResources().getDrawable(R.drawable.send_bg));
            msg.setTextColor(context.getResources().getColor(android.R.color.black));
            msg.setGravity(Gravity.LEFT);
            time_tv.setTextColor(context.getResources().getColor(R.color.grey));
            time_tv.setVisibility(View.VISIBLE);
        }
        else if(sentOrReceived==Message.RECEIVE){
            parentLayout.setGravity(Gravity.LEFT);
            layout.setBackground(context.getResources().getDrawable(R.drawable.receive_bg));
            msg.setTextColor(context.getResources().getColor(android.R.color.black));
            msg.setGravity(Gravity.LEFT);
            time_tv.setTextColor(context.getResources().getColor(R.color.grey));
            time_tv.setVisibility(View.VISIBLE);
        }
        else if(sentOrReceived==Message.DATE){
            parentLayout.setGravity(Gravity.CENTER);
            layout.setBackground(context.getResources().getDrawable(R.drawable.center_bg));
            msg.setTextColor(context.getResources().getColor(android.R.color.black));
            msg.setGravity(Gravity.CENTER);
            time_tv.setVisibility(View.GONE);
        }
    }

}

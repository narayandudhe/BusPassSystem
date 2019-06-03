package com.example.nd.buspasssystem;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public ViewHolder(View itemView){
        super(itemView);

        mView=itemView;

    }
    public void setDetails(Context ctx, String site_name, String site_address, String url, String status)
    {
        TextView mname=mView.findViewById(R.id.textViewJobTitle);
        TextView maddress=mView.findViewById(R.id.textViewType);
        TextView mimg=mView.findViewById(R.id.textViewLocation);
        TextView ac=mView.findViewById(R.id.textViewStatus);
        mname.setText(site_name);
        maddress.setText(site_address);
        mimg.setText(url);
        if(status.equals(" "))
        {
        ac.setText("Not Approved");
        }
        else
        {
            ac.setText("Approved");
        }
    }

}
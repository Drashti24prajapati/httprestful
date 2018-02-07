package com.assignment.homeassignment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.assignment.homeassignment.Controller.AppController;
import com.assignment.homeassignment.Model.ModelUserdetails;
import com.assignment.homeassignment.R;
import com.assignment.homeassignment.Userdetails;

import java.util.ArrayList;

/**
 * Created by ND on 2017-12-09.
 */

public class AdapterUserList extends RecyclerView.Adapter<AdapterUserList.ViewHolder> {
    Context context;
    ArrayList<ModelUserdetails> arrayUserDetails;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public AdapterUserList(Context context, ArrayList<ModelUserdetails> arrayUserDetails) {
        this.context = context;
        this.arrayUserDetails = arrayUserDetails;
    }

    @Override
    public AdapterUserList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.userlist_custom, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterUserList.ViewHolder holder, int position) {
        ModelUserdetails modelUserdetails = arrayUserDetails.get(position);
        holder.txtuserID.setText(modelUserdetails.getUserID());
        holder.txtUserName.setText(modelUserdetails.getUserFirstName() + " " + modelUserdetails.getUserLastName());
        holder.imgUserPotraint.setImageUrl(modelUserdetails.getUserPortrait(), imageLoader);
        holder.imgStar.setColorFilter(Color.parseColor(modelUserdetails.getUserBedgeColor()));
    }

    @Override
    public int getItemCount() {
        return arrayUserDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtuserID, txtUserName;
        NetworkImageView imgUserPotraint;
        ImageView imgStar;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtuserID = (TextView) itemView.findViewById(R.id.txtID);
            txtUserName = (TextView) itemView.findViewById(R.id.txtUserName);
            imgUserPotraint = (NetworkImageView) itemView.findViewById(R.id.imgUser);
            imgStar = (ImageView) itemView.findViewById(R.id.imgStar);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Log.i("position", "" + position);

                ModelUserdetails user = arrayUserDetails.get(position);
                Intent intent = new Intent(context, Userdetails.class);
                intent.putExtra("Userdata", user);
                context.startActivity(intent);
            }
        }
    }








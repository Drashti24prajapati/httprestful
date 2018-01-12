package com.assignment.homeassignment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.assignment.homeassignment.Controller.AppController;
import com.assignment.homeassignment.Model.ModelUserdetails;

/**
 * Created by ND on 2017-12-10.
 */

public class Userdetails extends AppCompatActivity {
    NetworkImageView imgUserPotrait;
    ImageView imgStar;
    TextView txtID, txtUserName, txtdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetails);
        Log.i("in", "in");
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        imgUserPotrait = (NetworkImageView) findViewById(R.id.imgUserPotrait);

        imgStar = (ImageView) findViewById(R.id.imgStar);
        txtID = (TextView) findViewById(R.id.txtID);
        txtUserName = (TextView) findViewById(R.id.txtUserName);
        txtdesc = (TextView) findViewById(R.id.txtdesc);

        ModelUserdetails userdetails = new ModelUserdetails();
        userdetails = (ModelUserdetails) getIntent().getSerializableExtra("Userdata");
        Log.i("user", "" + userdetails);
        imgUserPotrait.setImageUrl(userdetails.getUserPortrait(), imageLoader);
        Log.i("username", "" + userdetails.getUserLastName());
        imgStar.setColorFilter(Color.parseColor(userdetails.getUserBedgeColor()));
        txtID.setText(userdetails.getUserID());
        txtUserName.setText(userdetails.getUserFirstName() + " " + userdetails.getUserLastName());
        txtdesc.setText(userdetails.getUserDesc());
    }
}

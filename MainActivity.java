package com.assignment.homeassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.assignment.homeassignment.HTTPClass.HTTP_UserDetails;
import com.assignment.homeassignment.Model.ModelUserdetails;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        new HTTP_UserDetails(MainActivity.this, recyclerView).execute();


    }

}

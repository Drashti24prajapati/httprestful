package com.assignment.homeassignment.HTTPClass;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.assignment.homeassignment.Adapter.AdapterUserList;
import com.assignment.homeassignment.Controller.Connection;
import com.assignment.homeassignment.Controller.GridSpacingItemDecoration;
import com.assignment.homeassignment.Controller.WebUrl;
import com.assignment.homeassignment.Model.ModelUserdetails;
import com.assignment.homeassignment.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ND on 2017-12-09.
 */

public class HTTP_UserDetails extends AsyncTask<String, Void, String> {

    ProgressDialog mProgressDialog;
    Context context;
    ArrayList<ModelUserdetails> arrayUserDetails;
    RecyclerView recyclerView;
    AdapterUserList adpaterUserList;

    public HTTP_UserDetails(Context context, RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;

    }

    @Override
    protected void onPreExecute() {
        mProgressDialog = ProgressDialog.show(context, "",
                "Please wait. . .");

    }

    @Override
    protected String doInBackground(String... params) {
        arrayUserDetails = new ArrayList<ModelUserdetails>();
        try {

            String url = WebUrl.UserDetailsUrl;

            String str_response = Connection.getconnection(url, context);

            JSONObject jobj = new JSONObject(str_response);

            JSONArray jarrayUserDetails = jobj.getJSONArray("List");


            for (int i = 0; i < jarrayUserDetails.length(); i++) {

                ModelUserdetails modelUserDetails = new ModelUserdetails();

                JSONObject jobjUsertDetails = jarrayUserDetails.getJSONObject(i);
                modelUserDetails.setUserID(jobjUsertDetails.getString(context.getResources().getString(R.string.Id)));
                modelUserDetails.setUserFirstName(jobjUsertDetails.getString(context.getResources().getString(R.string.firstName)));
                modelUserDetails.setUserLastName(jobjUsertDetails.getString(context.getResources().getString(R.string.lastName)));
                modelUserDetails.setUserPortrait(jobjUsertDetails.getString(context.getResources().getString(R.string.portrait)));
                modelUserDetails.setUserBedgeColor(jobjUsertDetails.getString(context.getResources().getString(R.string.badgeColor)));
                modelUserDetails.setUserDesc(jobjUsertDetails.getString(context.getResources().getString(R.string.description)));
                arrayUserDetails.add(modelUserDetails);
                Log.i("arrayuerdetails", "" + arrayUserDetails.get(i));
            }
            Log.i("arrayuserlist", "" + arrayUserDetails.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        mProgressDialog.dismiss();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, GridSpacingItemDecoration.dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adpaterUserList = new AdapterUserList(context, arrayUserDetails);
        recyclerView.setAdapter(adpaterUserList);

    }

}

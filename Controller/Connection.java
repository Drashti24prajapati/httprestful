package com.assignment.homeassignment.Controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by ND on 2017-12-09.
 */

public class Connection {
    public static String getconnection(String url, Context context) {

        String str_response = "";
        HttpURLConnection client;

        try {
            URL url1 = new URL(url);
            client = (HttpURLConnection) url1.openConnection();
            int code = client.getResponseCode();

            // String message = client.getResponseMessage();
            if (code != 200) {

            } else {

            }

            Log.i("status code ", "" + code);

            InputStream in = new BufferedInputStream(client.getInputStream());
            str_response = Parsing.convertStreamToString(in);
            client.disconnect();
            Log.i("response", str_response);
        } catch (Exception e) {
            str_response = "";
            e.printStackTrace();
        }

        return str_response;
    }

    public static boolean isconnection(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    public static void postconnection(RequestQueue queue, String url, final Map<String, String> param,
                                      Context context, ProgressDialog mProgressDialog, Response.Listener<String> lis_res, Response.ErrorListener lis_error) {

        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";
        try {
            Log.d("url", url);

            StringRequest postRequest = new StringRequest(Request.Method.POST, url, lis_res, lis_error
            ) {


                @Override
                protected Map<String, String> getParams() {
                    Log.d("parameter", param + "");
                    return param;
                }
            };
            queue.add(postRequest);
            //AppController.getInstance().addToRequestQueue(postRequest, tag_json_obj);

        } catch (Exception e) {
            e.printStackTrace();
            mProgressDialog.dismiss();
        }
    }
}

package com.assignment.homeassignment.Model;

import android.graphics.Color;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by ND on 2017-12-09.
 */

public class ModelUserdetails implements Serializable{

    String UserID;
    String UserFirstName,UserLastName,UserPortrait,UserDesc,UserBedgeColor;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        UserFirstName = userFirstName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getUserPortrait() {
        return UserPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        UserPortrait = userPortrait;
    }

    public String  getUserBedgeColor() {
       String colorcode = "#" + UserBedgeColor.substring(2);
        Log.i("colorcode",""+colorcode);
        return colorcode;
    }

    public void setUserBedgeColor(String userBedgeColor) {
        UserBedgeColor = userBedgeColor;
    }

    public String getUserDesc() {
        return UserDesc;
    }

    public void setUserDesc(String userDesc) {
        UserDesc = userDesc;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

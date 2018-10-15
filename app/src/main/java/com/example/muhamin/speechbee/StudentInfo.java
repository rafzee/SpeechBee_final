package com.example.muhamin.speechbee;

import android.net.Uri;

/**
 * Created by sonaila on 9/30/2018.
 */

public class StudentInfo {

    private String uname, uage, uphn, uemail;

    public StudentInfo() {

    }

    public StudentInfo(String uname, String uage, String uphn, String uemail) {
        this.uname = uname;
        this.uage = uage;
        this.uphn = uphn;
        this.uemail = uemail;
    }



    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage;
    }

    public String getUphn() {
        return uphn;
    }

    public void setUphn(String uphn) {
        this.uphn = uphn;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }
}

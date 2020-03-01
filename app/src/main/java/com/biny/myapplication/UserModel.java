package com.biny.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    public  String fname;
    public  String lname;
    public  String email;
    public String username;
    public  String phoneNo;
    public  String password;
    public  String gender;

    public UserModel(String fname, String lname, String email, String username, String phoneNo, String password, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.phoneNo = phoneNo;
        this.password = password;
        this.gender = gender;
    }

    protected UserModel(Parcel in) {
        fname = in.readString();
        lname = in.readString();
        email = in.readString();
        username = in.readString();
        phoneNo = in.readString();
        password = in.readString();
        gender = in.readString();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getFname() {
        return fname;
    }

    public UserModel setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return lname;
    }

    public UserModel setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public UserModel setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fname);
        dest.writeString(lname);
        dest.writeString(email);
        dest.writeString(username);
        dest.writeString(phoneNo);
        dest.writeString(password);
        dest.writeString(gender);
    }
}



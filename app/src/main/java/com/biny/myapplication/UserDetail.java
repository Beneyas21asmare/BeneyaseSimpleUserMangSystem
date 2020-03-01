package com.biny.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {
    TextView fname,lname,email,username,phonenum,password,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);


        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        UserModel userModel=(UserModel) bundle.get("user");
        fname=(TextView)findViewById(R.id.fnamet);
        lname=(TextView)findViewById(R.id.lnamet);
        email=(TextView)findViewById(R.id.emailt);
        username=(TextView)findViewById(R.id.usernamet);
        phonenum=(TextView)findViewById(R.id.phonet);
        password=(TextView)findViewById(R.id.passwordt);
        gender=(TextView)findViewById(R.id.gendert);

        fname.setText("First Name : "+userModel.fname);
        lname.setText("Last Name : "+userModel.lname);
        email.setText("Email : "+userModel.email);
        username.setText("User Name: "+userModel.username);
        phonenum.setText("Phone num:"+userModel.phoneNo);
        password.setText("Password : "+userModel.password);
        gender.setText("Gender :  "+userModel.gender);


    }
}


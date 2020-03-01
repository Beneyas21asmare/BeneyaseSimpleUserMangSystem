package com.biny.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginInterface extends AppCompatActivity {
    protected EditText userName,password;
    protected Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_interface);
        userName=(EditText)findViewById(R.id.lUserName);
        password=(EditText)findViewById(R.id.lPassword);
        login=(Button)findViewById(R.id.lLogin);

    }

    public void buttonClicked(View view) {
        switch (view.getId()){
            case R.id.lLogin:
                String username=userName.getText().toString();
                String pass=password.getText().toString();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(this,"Please enter our username ",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(this,"PLease enter our password",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent1=new Intent(LoginInterface.this,DestinationClass.class);
                startActivity(intent1);
                break;

            default:
        }
    }
}

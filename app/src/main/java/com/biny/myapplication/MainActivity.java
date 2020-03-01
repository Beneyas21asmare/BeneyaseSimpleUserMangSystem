package com.biny.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button creat,haveAccount,clear;
    public RadioButton female,males;
    public EditText fname,lName,phone,email,password,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creat=(Button)findViewById(R.id.create);
        haveAccount=(Button)findViewById(R.id.haveAlreadyAccount);
        clear=(Button) findViewById(R.id.clear);
        fname=(EditText)findViewById(R.id.fname);
        lName=(EditText)findViewById(R.id.lname);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        username=(EditText)findViewById(R.id.userName) ;
        password=(EditText)findViewById(R.id.password);
        female=(RadioButton)findViewById(R.id.female);
        males=(RadioButton)findViewById(R.id.male);
    }

    public void buttonClicked(View view) {
        switch (view.getId()){
            case R.id.create:
                String gender =null;
                if(female.isChecked()){
                    gender="female";
                }
                if(males.isChecked()){
                    gender="male";
                }
                String fnam=fname.getText().toString();
                String lNam=lName.getText().toString();
                String phon=phone.getText().toString();
                String emai=email.getText().toString();
                String user=username.getText().toString().trim();
                String pass=password.getText().toString();
                boolean bool=(female.isChecked()||males.isChecked());


                if(TextUtils.isEmpty(fnam)){
                    Toast.makeText(this,"Please fill the fname field", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(lNam)){
                    Toast.makeText(this,"Please fill the lname field", Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(emai)){
                    Toast.makeText(this,"Please fill the email field", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(user)){
                    Toast.makeText(this,"Please fill the user field", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(phon)){
                    Toast.makeText(this,"Please fill the phone number field", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(this,"Please fill the password field", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!bool){
                    Toast.makeText(this,"Please select one from a checkButton", Toast.LENGTH_LONG).show();
                    return;
                }
                UserDBHelper usersDBHelper= new UserDBHelper(getApplicationContext());;
                if(usersDBHelper.checkUserNmaeFromSQLiteDB(user)) {

                    SQLiteDatabase sqLiteDatabase = usersDBHelper.getWritableDatabase();
                    usersDBHelper.registerUsers(fnam, lNam, emai, user, phon, pass, gender, sqLiteDatabase);

                    Toast.makeText(this, "Successfully registered", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, LoginInterface.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"This user have already an account",Toast.LENGTH_LONG).show();
                    username.setText("");
                }

                break;
            case R.id.haveAlreadyAccount:
                Intent intent1=new Intent(MainActivity.this,LoginInterface.class);
                startActivity(intent1);
                break;
            case R.id.clear:
                fname.setText("");
                lName.setText("");
                email.setText("");
                username.setText("");
                phone.setText("");
                password.setText("");
                female.setChecked(false);
                males.setChecked(false);
                break;

            default:

        }
    }
    }


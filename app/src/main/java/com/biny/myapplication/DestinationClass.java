package com.biny.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DestinationClass extends AppCompatActivity {
    Button logout ,viewUsers;
    RecyclerView recyclerView;
    TextView textView;
    UserDBHelper usersDBHelper;
    SQLiteDatabase sqLiteDatabase;
    AdapterClass userAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_class);
        usersDBHelper=new UserDBHelper(getApplicationContext());
        sqLiteDatabase=usersDBHelper.getReadableDatabase();
        cursor=usersDBHelper.fetchingUsersFromSQLiteDB(sqLiteDatabase);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter=new AdapterClass(this,getUsers());
        recyclerView.setAdapter(userAdapter);

        textView=(TextView)findViewById(R.id.text) ;
        logout=(Button)findViewById(R.id.logout);
        viewUsers=(Button)findViewById(R.id.viewUser);
        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DestinationClass.this,DestinationClass.class);
                startActivity(intent);

            }});


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();



            }
        });


    }


    public Cursor getUsers() {
        return sqLiteDatabase.rawQuery("select *from " + UsersData.UsersDataEntry.TABLE_NAME, null);
    }
}
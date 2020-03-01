package com.biny.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDBHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME="usersDatabase";
    public static Integer VERSION=1;
    public static String CREATE_TABLE="create table "+UsersData.UsersDataEntry.TABLE_NAME+
            "("+UsersData.UsersDataEntry.FNAME+" text,"+UsersData.UsersDataEntry.LNAME+" text, " +
            ""+UsersData.UsersDataEntry.EMAIL+" text,"+UsersData.UsersDataEntry.USERNAME+" text,"
            +UsersData.UsersDataEntry.PHONE_NO+" number,"+UsersData.UsersDataEntry.PASSWORD+" text,"
            +UsersData.UsersDataEntry.GENDER+" text);";
    public static String DROP_TABLE="drop  table if exists "+UsersData.UsersDataEntry.TABLE_NAME;
    public UserDBHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
        Log.d("Database Constractor","Database created");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("On create table","Table is created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        Log.d("Inside upgrade method","The table is upgraded");

    }
    public void registerUsers(String fname,String lname,String email,String user,
                              String phone_no,String password,String gender,SQLiteDatabase database){
        ContentValues contentValues=new ContentValues();
        contentValues.put(UsersData.UsersDataEntry.FNAME,fname);
        contentValues.put(UsersData.UsersDataEntry.LNAME,lname);
        contentValues.put(UsersData.UsersDataEntry.EMAIL,email);
        contentValues.put(UsersData.UsersDataEntry.USERNAME,user);
        contentValues.put(UsersData.UsersDataEntry.PHONE_NO,phone_no);
        contentValues.put(UsersData.UsersDataEntry.PASSWORD,password);
        contentValues.put(UsersData.UsersDataEntry.GENDER,gender);
        database.insert(UsersData.UsersDataEntry.TABLE_NAME,null,contentValues);
        Log.d("On user defined method","one row is affected");

    }
    public boolean checkUserNmaeFromSQLiteDB(String username){
        String CHECK_USER_NAME="select *from "+UsersData.UsersDataEntry.TABLE_NAME+" where "+username+" = "+UsersData.UsersDataEntry.USERNAME;
        if(CHECK_USER_NAME.isEmpty()){
            return  false;
        }
        else
            return true;

    }

    public Cursor fetchingUsersFromSQLiteDB(SQLiteDatabase sqLiteDatabase){
        String userInfo[]={UsersData.UsersDataEntry.FNAME,UsersData.UsersDataEntry.LNAME,
                UsersData.UsersDataEntry.EMAIL,UsersData.UsersDataEntry.USERNAME,UsersData.UsersDataEntry.PHONE_NO,
                UsersData.UsersDataEntry.PASSWORD,UsersData.UsersDataEntry.GENDER};
        Cursor cursor=sqLiteDatabase.query(UsersData.UsersDataEntry.TABLE_NAME,userInfo,null,null,null,null,null);
        return cursor;

    }
    public int delateData(int index){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=getAll();
        cursor.moveToPosition(index);

        //sqLiteDatabase.delete(UsersData.UsersDataEntry.TABLE_NAME,UsersData.UsersDataEntry.USERNAME+" != "+index,null);
        return sqLiteDatabase.delete(UsersData.UsersDataEntry.TABLE_NAME,UsersData.UsersDataEntry.USERNAME+"=?",new String[]{cursor.getString(4)});
    }
    public  Cursor getAll(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        return sqLiteDatabase.rawQuery("select *from "+UsersData.UsersDataEntry.TABLE_NAME,null);
    }

}



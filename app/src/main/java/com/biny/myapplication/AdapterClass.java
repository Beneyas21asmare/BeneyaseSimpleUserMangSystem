package com.biny.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.UserViewHolder> {
    private Context rContext;
    private Cursor rcursor;
    public  AdapterClass(Context context,Cursor cursor){
        rContext=context;
        rcursor=cursor;

    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(rContext).inflate(R.layout.recyclerlayout,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserViewHolder holder, final int position) {
        // holder.textView.setText(users.get(position).);
        if(!rcursor.moveToPosition(position)){
            Toast.makeText(rContext,"NO data",Toast.LENGTH_LONG).show();
            return;
        }
        final String fname=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.FNAME));
        String lname=rcursor.getString((rcursor.getColumnIndex(UsersData.UsersDataEntry.LNAME)));
        String fullname=fname+" "+lname;
        holder.textView.setText(fullname);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.FNAME));
                String lName=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.LNAME));
                String Em=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.EMAIL));
                String user=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.USERNAME));
                String phone=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.PHONE_NO));
                String pass=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.PASSWORD));
                String gender=rcursor.getString(rcursor.getColumnIndex(UsersData.UsersDataEntry.GENDER));
                String ful_name="\n\n fullName : "+fName+"  "+lName;
                String em="\n Email : "+Em;
                String usern="\n UserName : "+user;
                String phon="\n Phone number : "+phone;
                String pas="\n Password : "+pass;
                String gen="\n Gender : "+gender;
                String strar[]={em,usern,phon,pas,gen};


                // holder.textView.setText(strar.toString());

                UserModel userModel=new UserModel(fname,lName,Em,user,phone,pass,gender);
                Intent intent=new Intent(holder.itemView.getContext(), UserDetail.class);
                intent.putExtra("user",userModel);
                holder.textView.getContext().startActivity(intent);


            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                UserDBHelper usersDBHelper=new UserDBHelper(rContext);
                usersDBHelper.delateData(getItemCount());
                rContext.databaseList();
                rcursor.moveToNext();

                return true;
            }
        });



    }

    @Override
    public int getItemCount() {

        return rcursor.getCount();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.ltext);
        }


    }
}

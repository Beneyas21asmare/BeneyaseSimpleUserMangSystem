package com.biny.myapplication;

public class UsersData {
    private UsersData(){}
    public static class UsersDataEntry {

            public static String TABLE_NAME="tUsers_Data_Entry";
            public static String FNAME="fname";
            public static String LNAME="lName";
            public static String EMAIL="email";
            public static String USERNAME="username";
            public static String PHONE_NO="phone_no";
            public static String PASSWORD="password";
            public static String GENDER="gender";

            public UsersDataEntry() {
            }

            public static String getFNAME() {
                return FNAME;
            }

            public static void setFNAME(String FNAME) {
                UsersDataEntry.FNAME = FNAME;
            }

            public static String getLNAME() {
                return LNAME;
            }

            public static void setLNAME(String LNAME) {
                UsersDataEntry.LNAME = LNAME;
            }

            public static String getEMAIL() {
                return EMAIL;
            }

            public static void setEMAIL(String EMAIL) {
                UsersDataEntry.EMAIL = EMAIL;
            }

            public static String getUSERNAME() {
                return USERNAME;
            }

            public static void setUSERNAME(String USERNAME) {
                UsersDataEntry.USERNAME = USERNAME;
            }

            public static String getPhoneNo() {
                return PHONE_NO;
            }

            public static void setPhoneNo(String phoneNo) {
                PHONE_NO = phoneNo;
            }

            public static String getPASSWORD() {
                return PASSWORD;
            }

            public static void setPASSWORD(String PASSWORD) {
                UsersDataEntry.PASSWORD = PASSWORD;
            }

            public static String getGENDER() {
                return GENDER;
            }

            public static void setGENDER(String GENDER) {
                UsersDataEntry.GENDER = GENDER;
            }


        }}





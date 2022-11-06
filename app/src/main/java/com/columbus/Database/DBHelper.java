package com.columbus.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pansala.CHEventConstants;
import com.pansala.CHEventModel;
import com.pansala.NConstants;
import com.pansala.NModelRecord;
import com.pansala.Session.Session;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "columbus.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String  SQL_CREATE_ENTRIES = "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" +
                UsersMaster.Users._ID + " INTEGER PRIMARY KEY," +
                UsersMaster.Users.COLUMN_FULLNAME + " Text," +
                UsersMaster.Users.COLUMN_BIRTHDAY + " Text," +
                UsersMaster.Users.COLUMN_NIC + " Number," +
                UsersMaster.Users.COLUMN_EMAIL + " Text," +
                UsersMaster.Users.COLUMN_CONTACTNO + " Number," +
                UsersMaster.Users.COLUMN_PASSWORD + " Text," +
                UsersMaster.Users.COLUMN_TYPE + " Text)" ;

        db.execSQL(SQL_CREATE_ENTRIES); //Create user table

        //Create dahampasal table
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, pansalaName TEXT, chiefThero TEXT, dahampasalaName TEXT, studentsCount INTEGER, classesCount INTEGER  )");

        //Create Event table
        db.execSQL(CHEventConstants.CREATE_TABLE);

        //Create temple table
        db.execSQL(NConstants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsersMaster.Users.TABLE_NAME);
    }

    //User control ******************************************************************************************************************************************

    public long addUser(String fullname, String birthday, String nic,
                        String email, String contactNo, String password){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_FULLNAME, fullname);
        values.put(UsersMaster.Users.COLUMN_BIRTHDAY, birthday);
        values.put(UsersMaster.Users.COLUMN_NIC, nic);
        values.put(UsersMaster.Users.COLUMN_EMAIL, email);
        values.put(UsersMaster.Users.COLUMN_CONTACTNO, contactNo);
        values.put(UsersMaster.Users.COLUMN_PASSWORD, password);
        values.put(UsersMaster.Users.COLUMN_TYPE, "user");

        long newUserId = db.insert(UsersMaster.Users.TABLE_NAME,
                null, values);
        return newUserId;
    }




package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "usersdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "myusers";
    private static final String USER_ID = "userid";
    private static final String USER_NAME = "username";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";

    public DataBaseHandler(@Nullable Context context) {
        super(context, DB_NAME,  null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_NAME + " TEXT,"
                + NAME + " TEXT,"
                + PASSWORD + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }
    public void addNewUser(Users users) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(USER_NAME, users.getUser_name());
        values.put(NAME, users.getName());
        values.put(PASSWORD, users.getPassword());

        sqLiteDatabase.insert(TABLE_NAME, null, values);

        sqLiteDatabase.close();
    }

    public ArrayList<Users> readUsers() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorUsers = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Users> usersModalArrayList = new ArrayList<>();

        if (cursorUsers.moveToFirst()) {
            do {
                usersModalArrayList.add(new Users(
                        cursorUsers.getString(1),
                        cursorUsers.getString(2),
                        cursorUsers.getString(3)));
            } while (cursorUsers.moveToNext());
        }

        cursorUsers.close();
        return usersModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

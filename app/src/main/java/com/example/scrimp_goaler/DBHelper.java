package com.example.scrimp_goaler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
    DB.execSQL("create Table User(id number primary key,name Text,location Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists User");

    }

    public Boolean insertUserdata(String id, String name, String location){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("location",location);
        long result = DB.insert("User",null,contentValues);
        if(result==1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean updateUserdata(String id, String name, String location) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("location", location);
        Cursor cursor = DB.rawQuery("Select * from User where name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("User", contentValues, "name=?", new String[]{name});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteUserdata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from User where name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("User", "name=?", new String[]{name});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getUserdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from User",null);
        return cursor;
    }


}

package com.example.scrimp_goaler;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    public static final String goalvalue = "Goal value";
    public static final String goaldescription = "Goal description";
    public static final String goalPeriod = "Period";
    public static final String goalstartdate = "Start date";
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table goals(goalvalue TEXT primary key,goaldescription TEXT , goalperiod TEXT ,goalstartdate TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertGoals(String goalvalue, String goaldescription,String goalperiod, String goalstartdate){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("value",goalvalue);
        contentValues.put("description", goaldescription);
        contentValues.put("period", goalperiod);
        contentValues.put("start date", goalstartdate);
        long result = MyDB.insert("goals", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor result = MyDB.rawQuery("Select * from " + "goals", null);
        return result;
    }

}

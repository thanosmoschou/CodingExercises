/*
Author: Thanos Moschou
Description: This is a simple project in order to learn how to use local sqlite db.
 */

package com.example.learnsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "names.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "person";


    public DBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String query = "CREATE TABLE " + TABLE_NAME + "( name TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    public void addName(String aName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", aName);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public List<String> selectAllNames()
    {
        List<String> names = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(c.moveToFirst())
        {
            do
            {
                names.add(c.getString(0));
            }
            while(c.moveToNext());
        }

        db.close();
        return names;
    }
}

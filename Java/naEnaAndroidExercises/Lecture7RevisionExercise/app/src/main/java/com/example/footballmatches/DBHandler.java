package com.example.footballmatches;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper
{
    private static final String DB_NAME = "games.db";
    private static final int DB_VERSION = 1;
    private static final String tableName = "Games";

    private static DBHandler dbHandler = null;

    private DBHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DBHandler getInstance(Context context)
    {
        if(dbHandler == null)
            dbHandler = new DBHandler(context);
        return dbHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String query = "CREATE TABLE " + tableName + "(team1 TEXT, team2 TEXT, winner TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(sqLiteDatabase);
    }

    public void deleteAllRows()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db, -1, -1);
    }

    public void addRecord(String homeTeam, String visitorTeam, String winner)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("team1", homeTeam);
        values.put("team2", visitorTeam);
        values.put("winner", winner);

        db.insert(tableName, null, values);
        db.close();
    }

    public List<String> readDB()
    {
        List<String> rows = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + tableName, null);
        if(c.moveToFirst())
        {
            do
                rows.add(c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            while(c.moveToNext());
        }

        db.close();
        return rows;
    }
}

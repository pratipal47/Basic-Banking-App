package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'John wick', 'john@gmail.com','7584','7895641238', 14000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Lady gaga', 'gaga@gmail.com','1258','8995641238', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Justin timberlake', 'justin@gmail.com','8896','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Ryan renoldws', 'ryan@gmail.com','7752','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Ryan gosllin', 'gosllin@gmail.com','3669','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Kevin harts', 'kevin@gmail.com','9985','8855640238', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yash Chopra', 'ychopra@gmail.com','1207','8895640215', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Messi leo', 'messi@gmail.com','4522','9985021539', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Leonardo Decaprio', 'leonardo@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Cilian murfy', 'cilian@gmail.com','5450','8292591201', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Tom hardy', 'tom@gmail.com','2656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Dywan jonson', 'jonson@gmail.com','1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'kim jisso', 'kimjisso@gmail.com','5566','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'lalisa manoban', 'lalisa@gmail.com','2236','6254642205', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Micheal scott', 'micheal@gmail.com','6692','6893641266', 1500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
} 
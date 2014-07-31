package com.example.dblearn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "DB_HELPER";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "TodoDb.db";
	
	public static final String COL_ITEM_TEXT = "itemText";
	public static final String TABLE_NAME = "TodoItems";
	
	private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " +COL_ITEM_TEXT + " TEXT" +")";
	
	public DbHelper(Context ctx) {
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v(TAG, "On create Called");
		Log.v(TAG, "Creating Table");
		db.execSQL(CREATE_TABLE);
		Log.v(TAG, "Table Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {	
		db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
		onCreate(db);
		
	}

}

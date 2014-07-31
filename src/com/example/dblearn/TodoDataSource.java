package com.example.dblearn;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TodoDataSource {
	private static final String TAG = "TODO_DATA_SOURCE";
	private SQLiteDatabase db;
	private DbHelper dbHelper;
	private String allColumns [] = {
			DbHelper.COL_ITEM_TEXT
	};
	
	public TodoDataSource(Context ctx){
		dbHelper = new DbHelper(ctx);
	}
	
	public void openDb() throws SQLException {
		Log.v(TAG, "Opening connection to DB");
		db = dbHelper.getWritableDatabase();
	}
	
	public void closeDb(){
		Log.v(TAG, "Closing connection to DB");
		dbHelper.close();
	}
	
	public void createTodoItem(String text) {
		openDb();
		ContentValues values = new ContentValues();
		values.put(DbHelper.COL_ITEM_TEXT, text);
		Log.v(TAG, "Inserting item to db :"+text);
		db.insert(DbHelper.TABLE_NAME, null, values);
		closeDb();
	}
	
	public ArrayList<TodoItem> getAllTodoItems(){
		Log.v(TAG, "Getting all items from Db");
		ArrayList <TodoItem> items = new ArrayList<TodoItem>();
		openDb();
		Cursor c = db.query(DbHelper.TABLE_NAME, allColumns, null, null, null, null, null);
		if( c!= null) c.moveToFirst();
		do {
			TodoItem item = new TodoItem(c.getString(0).toString());
			items.add(item);
		} while(c.moveToNext());
		closeDb();
		return items;
		
	}
	
	public int updateTodoItem(String oldText, String newText) {
		openDb();
		ContentValues values = new ContentValues();
		values.put(DbHelper.COL_ITEM_TEXT, newText);
		Log.v(TAG, "Updating todo item : "+oldText+" to item :"+newText);
		int rv = db.update(DbHelper.TABLE_NAME, values, DbHelper.COL_ITEM_TEXT +" =?", new String[]{oldText});
		closeDb();
		return rv;
		
	}
	
	public void removeTodoItem(String text) {
		openDb();
		Log.v(TAG, "Removing todo item : "+text);
		db.delete(DbHelper.TABLE_NAME, DbHelper.COL_ITEM_TEXT +" =?", new String[]{text});
		closeDb();
	}
}

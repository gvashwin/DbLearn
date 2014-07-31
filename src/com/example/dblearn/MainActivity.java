package com.example.dblearn;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	private TodoDataSource todoDS;
	private ArrayList <TodoItem> myTodoItems;
	private static final String TAG = "MAIN_ACTIVITY";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		todoDS = new TodoDataSource(this);
		todoDS.createTodoItem("item 1");
		todoDS.createTodoItem("item 2");
		todoDS.createTodoItem("item 3");
		todoDS.createTodoItem("item 4");
		todoDS.createTodoItem("item 5");
		
		myTodoItems = todoDS.getAllTodoItems();
		for (TodoItem item : myTodoItems) {
			Log.v(TAG, "The todo item is "+ item.getItemText());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

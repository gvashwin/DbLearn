package com.example.dblearn;

public class TodoItem {
	
	private String itemText;
	
	public TodoItem() {
		itemText = null;
	}
	public TodoItem(String text) {
		itemText = text;
	}
	public String getItemText(){
		return itemText;
	}
	public void setItemText(String text){
		itemText = text;		
	}
	
	public String toString() {
		return ""+itemText;
	}

}

package com.example.musicmedia;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Mnext extends ListActivity {

	String classes[]={"vijay","karthi","jaga","jagan","jagaethesh"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mnext);
		setListAdapter(new ArrayAdapter<String>(Mnext.this,android.R.layout.simple_list_item_1,classes));
		
		
	}
}

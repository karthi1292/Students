package com.example.musicmedia;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Next extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		Toast.makeText(getApplicationContext(), "karthick", Toast. LENGTH_LONG).show();
		}
}

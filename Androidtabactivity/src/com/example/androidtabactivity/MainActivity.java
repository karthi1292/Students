package com.example.androidtabactivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  TabHost tabHost = getTabHost();
	         
	        // Tab for Photos
	        TabSpec photospec = tabHost.newTabSpec("Photos");
	        // setting Title and Icon for the Tab
	        photospec.setIndicator("adhotos",getResources().getDrawable(R.drawable.photos_gray));
	        Intent photosIntent = new Intent(MainActivity.this,PhotosActivity.class);
	        photospec.setContent(photosIntent);
	         
	        // Tab for Songs
	        TabSpec songspec = tabHost.newTabSpec("Songs");        
	        songspec.setIndicator("Songs", getResources().getDrawable(R.drawable.songs));
	        Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
	        songspec.setContent(songsIntent);
	         
	        // Tab for Videos
	        TabSpec videospec = tabHost.newTabSpec("Videos");
	        videospec.setIndicator("Videos", getResources().getDrawable(R.drawable.svideo));
	        Intent videosIntent = new Intent(MainActivity.this, VideosActivity.class);
	        videospec.setContent(videosIntent);
	         
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(photospec); // Adding photos tab
	        tabHost.addTab(songspec); // Adding songs tab
	        tabHost.addTab(videospec); // Adding videos tab
	    }
	
}

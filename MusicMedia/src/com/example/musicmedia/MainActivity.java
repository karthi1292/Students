package com.example.musicmedia;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends Activity {

	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		ourSong=MediaPlayer.create(MainActivity.this,R.raw.splashsound);
		ourSong.start();
		
	Thread timer=new Thread(){
		public void run(){
			try{
				sleep(5000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			finally{
				Intent startingpoint=new Intent(MainActivity.this,Next.class);
				startActivity(startingpoint);
			}
		}
	};
	
	timer.start();
	}
	
	@Override
	protected void onPause(){

		super.onPause();
		ourSong.release();
		finish();
	}
}

package com.example.customlistviewvolley;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import android.text.TextUtils;

public class AppController extends Application{
	
	public static final String TAG=AppController.class.getSimpleName();
	
	private RequestQueue reqQueue;
	private ImageLoader imgLoader;
	private static AppController mInstance;
	
	@Override
	public void onCreate(){
		 
		super.onCreate();
		mInstance=this;
	}
	
	public static  synchronized AppController getInstance(){
		
		return mInstance;
	}
	
	public RequestQueue getRequestQueue(){
		if(reqQueue==null){
			
			reqQueue =Volley.newRequestQueue(getApplicationContext());
		}
		return reqQueue;
		}
	public ImageLoader getImageLoader(){
		getRequestQueue();
		if(imgLoader==null){
			
			imgLoader=new ImageLoader(this.reqQueue,new LruBitmapCache());
		}
		
		return this.imgLoader;
	}
	
	public <T> void addToRequestQueue(Request<T> req,String tag){
	
	req.setTag(TextUtils.isEmpty(tag)? TAG :tag);
	getRequestQueue().add(req);
	}
	
	
	public <T> void addToRequestQueue(Request<T> req){
		
		req.setTag(TAG);
		getRequestQueue().add(req);
	}
	
	public void cancelPendingRequests(Object tag){
		
		if(reqQueue!=null){
			reqQueue.cancelAll(tag);
		}
	}
}
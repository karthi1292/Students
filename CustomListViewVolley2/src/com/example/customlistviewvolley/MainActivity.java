package com.example.customlistviewvolley;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


public class MainActivity extends Activity {
	
	private static final String url = "http://api.androidhive.info/json/movies.json";
	
	private static final String TAG=MainActivity.class.getSimpleName();
	
	ListView listView;
	CustomAdapter adapter;
	ArrayList<Film> itemList=new ArrayList<Film>();
	ProgressDialog pdialog;
	public Film film;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView =(ListView)findViewById(R.id.listView1);
        adapter=new CustomAdapter(this,itemList);
        
        listView.setAdapter(adapter);
       
        
        pdialog=new ProgressDialog(this);
        pdialog.setMessage("Loading");
        pdialog.show();
        
        JsonArrayRequest itemReq=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

			@Override
			public void onResponse(JSONArray response) {
				// TODO Auto-generated method stub
				Log.d(TAG, response.toString());
				pdialog.dismiss();
				
				for(int i=0;i<response.length();i++){
					
					try{
					JSONObject obj=response.getJSONObject(i);
					
					film=new Film();
				
					
					film.setTitle(obj.getString("title"));
					film.setRating(((Number) obj.get("rating"))
                             .doubleValue());
					film.setReleaseyear(obj.getInt("releaseYear"));
					film.setImage(obj.getString("image"));
					
					JSONArray aray=obj.getJSONArray("genre");
					
					ArrayList<String> genre=new ArrayList<String>();
					for(int j=0;j<aray.length();j++){
						genre.add((String)aray.get(j));
					}
					film.setGenre(genre);
					
					itemList.add(film);
				}
					catch(JSONException e){
						e.printStackTrace();

					}
			}
				
				adapter.notifyDataSetChanged();	
		}
        }, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				  VolleyLog.d(TAG, "Error: " + error.getMessage());
				  pdialog.dismiss();
				
			}
		});
       
        AppController.getInstance().addToRequestQueue(itemReq);
    }
}

package com.example.customlistviewvolley;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	private Activity activity;
	private LayoutInflater inflater;
	private List<Film> itemList;
	ImageLoader imageLoader=AppController.getInstance().getImageLoader();
	private Film film;
	
	public CustomAdapter(Activity activity,List<Film> itemList){
		this.activity=activity;
		this.itemList=itemList;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return itemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
 
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.textView1);
        TextView rating=(TextView)convertView.findViewById(R.id.textView2);
        TextView year = (TextView) convertView.findViewById(R.id.textView4);
        TextView genre = (TextView) convertView.findViewById(R.id.textView3);
        
        film=itemList.get(position);
        thumbNail.setImageUrl(film.getImage(), imageLoader);
        title.setText(film.getTitle());
        year.setText(String.valueOf(film.getReleaseYear()));
        rating.setText(String.valueOf(film.getRating()));
        String genreStr = "";
        
        for (String str : film.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);
        Log.e("vsal", ""+genreStr);
        return convertView;
	}

}

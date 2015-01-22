package com.hemantchand.listviewwithstickytabbutton;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter< ElementModel>
{
	private final Activity	context;
	private final ArrayList< ElementModel>	names;
	
	static class ViewHolder
	{
		public TextView		text;
		public ImageView	image;
	}
	
	public MyAdapter (Activity context , ArrayList< ElementModel> names)
	{
		super(context , R.layout.list_element , names);
		this.context =context;
		this.names =names;
	}
	
	@Override
	public View getView (int position , View convertView , ViewGroup parent)
	{
		View rowView =convertView;
		ElementModel em = names.get(position);
		// reuse views
		if (rowView ==null )
		{
			LayoutInflater inflater =context.getLayoutInflater();
			rowView =inflater.inflate(R.layout.list_element , null);
			// configure view holder
			ViewHolder viewHolder =new ViewHolder();
			viewHolder.text =(TextView ) rowView.findViewById(R.id.textView1);
			rowView.setTag(viewHolder);
		}
		
		// fill data
		ViewHolder holder =(ViewHolder ) rowView.getTag();
		holder.text.setText(em.text);
		
		return rowView;
	}
}

package com.hemantchand.listviewwithstickytabbutton;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener
{
	ListView	             list;
	TextView	             tab1 , tab2 , tab1_main , tab2_main;
	ArrayList< ElementModel>	arrayList1	=new ArrayList< ElementModel>();
	ArrayList< ElementModel>	arrayList2	=new ArrayList< ElementModel>();
	MyAdapter	             adapter;
	
	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		list =(ListView ) findViewById(R.id.listView1);
		tab1_main =(TextView ) findViewById(R.id.tab1_main);
		tab2_main =(TextView ) findViewById(R.id.tab2_main);
		
		tab1_main.setBackgroundColor(getResources().getColor(R.color.white));
		tab1_main.setTextColor(getResources().getColor(R.color.blue));
		tab1_main.setOnClickListener(this);
		
		tab2_main.setBackgroundColor(getResources().getColor(R.color.blue));
		tab2_main.setTextColor(getResources().getColor(R.color.white));
		tab2_main.setOnClickListener(this);
		
		LinearLayout listHeaderView =(LinearLayout ) this.getLayoutInflater().inflate(R.layout.header , null);
		list.addHeaderView(listHeaderView);
		tab1 =(TextView ) findViewById(R.id.tab1);
		tab2 =(TextView ) findViewById(R.id.tab2);
		
		tab1.setBackgroundColor(getResources().getColor(R.color.white));
		tab1.setTextColor(getResources().getColor(R.color.blue));
		tab1.setOnClickListener(this);
		
		tab2.setBackgroundColor(getResources().getColor(R.color.blue));
		tab2.setTextColor(getResources().getColor(R.color.white));
		tab2.setOnClickListener(this);
		
		fillList();
		
		list.setOnScrollListener(new OnScrollListener()
		{
			@Override
			public void onScrollStateChanged (AbsListView view , int scrollState)
			{
				
			}
			
			@Override
			public void onScroll (AbsListView view , int firstVisibleItem , int visibleItemCount , int totalItemCount)
			{
				Rect scrollBounds =new Rect();
				view.getHitRect(scrollBounds);
				if ( ! ((LinearLayout ) findViewById(R.id.subheader_lay) ).getLocalVisibleRect(scrollBounds)
				        ||scrollBounds.height() < ((LinearLayout ) findViewById(R.id.subheader_lay) ).getHeight() )
				{
					System.out.println("TAGHCD=visible="+view.getFirstVisiblePosition());
					((LinearLayout ) findViewById(R.id.subheader_main) ).setVisibility(View.VISIBLE);
				}
				else if(view.getFirstVisiblePosition()>=1)
				{
					((LinearLayout ) findViewById(R.id.subheader_main) ).setVisibility(View.VISIBLE);
				}
				else
				{
					System.out.println("TAGHCD=gone="+view.getFirstVisiblePosition());
					((LinearLayout ) findViewById(R.id.subheader_main) ).setVisibility(View.GONE);
				}
			}
		});
	}
	
	private void fillList ()
	{
		for (int i =0;i <50;i ++ )
		{
			ElementModel em =new ElementModel();
			em.text ="Test tab one list " +i;
			ElementModel em1 =new ElementModel();
			em1.text ="Test tab two list " +i;
			arrayList1.add(em);
			arrayList2.add(em1);
		}
		adapter =new MyAdapter(this , arrayList1);
		new Handler().postDelayed(new Runnable()
		{
			public void run ()
			{
				list.setAdapter(adapter);
			}
		} , 10);
		
	}
	
	@Override
	public void onClick (View v)
	{
		switch (v.getId() )
		{
			case R.id.tab1:
				tab1.setBackgroundColor(getResources().getColor(R.color.blue));
				tab1.setTextColor(getResources().getColor(R.color.white));
				
				tab2.setBackgroundColor(getResources().getColor(R.color.white));
				tab2.setTextColor(getResources().getColor(R.color.blue));
				
				tab1_main.setBackgroundColor(getResources().getColor(R.color.blue));
				tab1_main.setTextColor(getResources().getColor(R.color.white));
				
				tab2_main.setBackgroundColor(getResources().getColor(R.color.white));
				tab2_main.setTextColor(getResources().getColor(R.color.blue));
				adapter =new MyAdapter(this , arrayList1);
				list.setAdapter(adapter);
				
				break;
			case R.id.tab2:
				tab1.setBackgroundColor(getResources().getColor(R.color.white));
				tab1.setTextColor(getResources().getColor(R.color.blue));
				
				tab2.setBackgroundColor(getResources().getColor(R.color.blue));
				tab2.setTextColor(getResources().getColor(R.color.white));
				
				tab1_main.setBackgroundColor(getResources().getColor(R.color.white));
				tab1_main.setTextColor(getResources().getColor(R.color.blue));
				
				tab2_main.setBackgroundColor(getResources().getColor(R.color.blue));
				tab2_main.setTextColor(getResources().getColor(R.color.white));
				adapter =new MyAdapter(this , arrayList2);
				list.setAdapter(adapter);
				
				break;
			
			case R.id.tab1_main:
				tab1.setBackgroundColor(getResources().getColor(R.color.blue));
				tab1.setTextColor(getResources().getColor(R.color.white));
				
				tab2.setBackgroundColor(getResources().getColor(R.color.white));
				tab2.setTextColor(getResources().getColor(R.color.blue));
				
				tab1_main.setBackgroundColor(getResources().getColor(R.color.blue));
				tab1_main.setTextColor(getResources().getColor(R.color.white));
				
				tab2_main.setBackgroundColor(getResources().getColor(R.color.white));
				tab2_main.setTextColor(getResources().getColor(R.color.blue));
				adapter =new MyAdapter(this , arrayList1);
				list.setAdapter(adapter);
				break;
			case R.id.tab2_main:
				tab1.setBackgroundColor(getResources().getColor(R.color.white));
				tab1.setTextColor(getResources().getColor(R.color.blue));
				
				tab2.setBackgroundColor(getResources().getColor(R.color.blue));
				tab2.setTextColor(getResources().getColor(R.color.white));
				
				tab1_main.setBackgroundColor(getResources().getColor(R.color.white));
				tab1_main.setTextColor(getResources().getColor(R.color.blue));
				
				tab2_main.setBackgroundColor(getResources().getColor(R.color.blue));
				tab2_main.setTextColor(getResources().getColor(R.color.white));
				adapter =new MyAdapter(this , arrayList2);
				list.setAdapter(adapter);
				break;
		
		}
	}
	
}

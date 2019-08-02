package com.example.test.smartparking;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;

public class AppController extends Application {
	
	static RequestQueue queue;
	static Context con;
	static HashMap<String, ArrayList<String>> hashMap;
	static ArrayList<Integer> arrayList; 
	
	public static void initialize(Context context){
		if(con == null)
			con = context;
			
	}
	
	public static RequestQueue getInstance(){
		if(queue == null)
			queue = Volley.newRequestQueue(con);
		return queue;
	}
	
	public static HashMap<String, ArrayList<String>> getHashMap(){
		if(hashMap == null)
			hashMap = new HashMap<String, ArrayList<String>>();
		return hashMap;
	}
	
	public static ArrayList<Integer> getArrayList(){
		if(arrayList == null)
			arrayList = new ArrayList<Integer>();
		return arrayList;
	}
}
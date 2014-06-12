package com.cc.mylashou.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ToolKits {
	
	public static SharedPreferences getSharedPreferences(Context context){
		return context.getSharedPreferences("com.cc.mylashou", Context.MODE_PRIVATE);
	}
	
	public static void putBoolean(Context context, String key,boolean value){
		Editor editor = getSharedPreferences(context).edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	
	public static boolean fetchBoolean(Context context,String key,boolean defaultValue){
		return getSharedPreferences(context).getBoolean(key, defaultValue);
	}

}

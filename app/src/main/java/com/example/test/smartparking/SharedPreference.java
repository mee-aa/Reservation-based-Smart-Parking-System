package com.example.test.smartparking;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

public class SharedPreference {
	
	private static Context context = null;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static Context getContext() {
        return context;
    }

    public static void initialize(Context con) {
        if (context == null) {
            context = con;
        }
        if (null == preferences) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        if (null == editor) {
            editor = preferences.edit();
        }
    }

    public static void save(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static void save(String key, Integer value) {
        save(key, String.valueOf(value));
    }

    public static void save(String key, Boolean value) {
        save(key, String.valueOf(value));
    }
    
    public static void save(String key, Long value) {
        save(key, String.valueOf(value));
    }

    public static String get(String key) {
        return preferences.getString(key, null);
    }

    public static Set<String> getObjectSet(String key) {
        return preferences.getStringSet(key, null);
    }

    public static void setObjectSet(String key, Set<String> array) {
        editor.putStringSet(key, array);
        editor.commit();
    }

    public static Boolean contains(String key) {
        return preferences.contains(key);
    }

    public static void removeKey(String key) {
        editor.remove(key);
        editor.commit();
    }
}

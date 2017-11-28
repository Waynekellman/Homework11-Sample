package com.example.rusili.homework11.common;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONObject;

public class Activityyy extends AppCompatActivity {

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);

		JSONObject jsonObject = new JSONObject();
		jsonObject.getJSONObject("popup").getJSONArray("menuitem").
	}
}

package com.example.rusili.homework11.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseAbstractActivity extends AppCompatActivity {
	private View container;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getActivityLayout());

		showLoadingFragment();
	}

	private void showLoadingFragment () {
		
	}

	protected void setContainer(View view){
		this.container = view;
	}

	protected abstract int getActivityLayout ();
}

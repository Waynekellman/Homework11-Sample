package com.example.rusili.homework11.common;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.View;

import com.example.rusili.homework11.R;

public abstract class FragmentAbstractActivity extends AppCompatActivity {
	public final FragmentManager fragmentManager = getSupportFragmentManager();
	private final LoadingFragment loadingFragment = new LoadingFragment();

	public View container;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.abstract_activity_layout);

		setContainer();
		setLoadingTransition();
	}

	private void setContainer () {
		this.container = findViewById(R.id.container);
	}
	public int getContainerId () {
		return container.getId();
	}

	private void setLoadingTransition () {
		if (Build.VERSION.SDK_INT >= 19) {
			Fade fade = new Fade();
			fade.setDuration(250);
			loadingFragment.setEnterTransition(fade);
			loadingFragment.setExitTransition(fade);
		}
	}

	public void showFragment (@NonNull AbstractFragment abstractFragment) {
		fragmentManager.beginTransaction()
			  .replace(getContainerId(), abstractFragment)
			  .addToBackStack(null)
			  .commit();
	}

	public void showLoadingFragment () {
		if (!loadingFragment.isAdded()) {
			fragmentManager.beginTransaction()
				  .add(container.getId(), loadingFragment)
				  .commit();
		}
	}

	public void hideLoadingFragment () {
		fragmentManager.beginTransaction()
			  .remove(loadingFragment)
			  .commit();
	}

	@Override
	public void onBackPressed () {
		super.onBackPressed();
		hideLoadingFragment();
	}
}

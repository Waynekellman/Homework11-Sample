package com.example.rusili.homework11.common;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.View;

import com.example.rusili.homework11.R;

//	This abstract Activity is only used when using Fragments.
//	I hold an instance of a fragment manager as well as extract a lot of boilerplate code that's required for fragment transactions.
//	Here you can also see the code I use for showing and hiding my loading screen.
public abstract class FragmentAbstractActivity extends AppCompatActivity {
	public final FragmentManager fragmentManager = getSupportFragmentManager();	// This is public because I need reference to it in the extended classes.
	private final LoadingFragment loadingFragment = new LoadingFragment();	// Here I DON'T want my extended classes to reference this, so I make it private.

	public View container;	//	The layout MUST contain an id called container, or else it will crash.

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		setContainer();
		setLoadingTransition();
	}

	protected abstract int getLayoutId();

	private void setContainer () {
		this.container = findViewById(R.id.container);	// This assumes my layout has a layout with the id of container. A bit scary.
	}
	public int getContainerId () {
		return container.getId();
	}

	//	Fragment transitions do not work below SDK 19. Also, I won't be calling it from my extended classes, so it's private.
	private void setLoadingTransition () {
		if (Build.VERSION.SDK_INT >= 19) {
			Fade fade = new Fade();	//	Android's own fade transition.
			fade.setDuration(250);	// I set it to 250 milliseconds, or 1/4 of a second.
			loadingFragment.setEnterTransition(fade);	// You can set both the enter and exit transitions.
			loadingFragment.setExitTransition(fade);
		}
	}

	//	Put all the fragment transaction code here so I don't have to write it everytime in my activity.
	public void showFragment (@NonNull AbstractFragment abstractFragment) {
		fragmentManager.beginTransaction()
			  .setCustomAnimations(0, R.anim.fade_out)	//	This gives the fragment enter and exit animations. It uses Android's anim animations.
			  .replace(getContainerId(), abstractFragment)	// Use replace instead of add unless you absolutely 100% know there's no fragment in the container.
			  .addToBackStack(null)
			  .commit();
	}

	public void showLoadingFragment () {
		if (!loadingFragment.isAdded() && !isFinishing()) {	//	Checks to make sure another loading fragment is not currently open.
			fragmentManager.beginTransaction()
				  .add(container.getId(), loadingFragment)
				  .commit();	//	I purposefully didn't add "addtoBackStack" because I don't want to be able to go back to my loading fragment.
		}
	}

	public void hideLoadingFragment () {
		fragmentManager.beginTransaction()
			  .remove(loadingFragment)
			  .commit();
	}

	//	Abstracted out the snackbar code. I just want to pass it my String, that's it.
	public void showSnackbar(@Nullable String message){
		Snackbar.make(container, "" + message, Snackbar.LENGTH_SHORT).show();
	}

	@Override
	public void onBackPressed () {
		super.onBackPressed();
		hideLoadingFragment();	// Make sure I remove the loading fragment when I navigate away from the activity.
	}
}

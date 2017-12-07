package com.example.rusili.homework11.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//  	An Abstract Fragment with the ability to get its Parent Activity and View
// 	as well as reduce boilerplate code with layout inflation
public abstract class AbstractFragment extends Fragment {
	private FragmentAbstractActivity parentActivity;	// Assumes the parent is of type FragmentAbstractActivity.
	public View parentView;	//	I save a public reference to my parentview for use later. I feel like a view is OK to leave as public.

	@Override
	public void onAttach (Context context) {
		super.onAttach(context);
		setParentActivity(context);	// Gets reference to the parent activity as soon as this fragment is attached to it.
	}

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		parentView = inflater.inflate(getLayoutId(), container, false);	// Here i replace the layout with a method so I can return it later on.
		onCreateView();	// Make sure your onCreateView stuff is AFTER your parentView is inflated.
		return parentView;
	}
	public abstract int getLayoutId ();
	public abstract void onCreateView ();

	private void setParentActivity (@NonNull Context context) {
		parentActivity = ((FragmentAbstractActivity) context);	// I cast my context to FragmentAbstractActivity because I know all my activities will be extending it.
	}

	@NonNull
	public FragmentAbstractActivity getParentActivity () {
		return parentActivity;
	}
}

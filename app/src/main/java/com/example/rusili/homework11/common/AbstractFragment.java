package com.example.rusili.homework11.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbstractFragment extends Fragment {
	private FragmentAbstractActivity parentActivity;
	public View parentView;

	@Override
	public void onAttach (Context context) {
		super.onAttach(context);
		setParentActivity(context);
	}

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		parentView = inflater.inflate(getLayoutId(), container, false);
		onCreateView();
		return parentView;
	}
	public abstract int getLayoutId ();
	public abstract void onCreateView ();

	private void setParentActivity (@NonNull Context context) {
		parentActivity = ((FragmentAbstractActivity) context);
	}

	@NonNull
	public FragmentAbstractActivity getParentActivity () {
		return parentActivity;
	}
}

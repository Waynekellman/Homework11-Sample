package com.example.rusili.homework11.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rusili.homework11.R;

public abstract class AbstractRecyclerViewViewholder <T> extends RecyclerView.ViewHolder implements View.OnClickListener {
	private Context context;
	private Resources resources;

	public AbstractRecyclerViewViewholder (@NonNull View itemView) {
		super(itemView);
		setupFields(itemView);
		setOnClickListeners();
		setViews();
	}

	private void setupFields (@NonNull View itemView) {
		context = itemView.getContext();
		resources = context.getResources();
	}

	public void setOnClickListeners () {
		itemView.setOnClickListener(this);
	}
	public abstract void setViews ();
	public abstract void bind (T t);

	protected Context getContext () {
		return context;
	}

	protected Resources getResources () {
		return resources;
	}
}

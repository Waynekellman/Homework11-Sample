package com.example.rusili.homework11.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AbstractRecyclerViewViewholder <T> extends RecyclerView.ViewHolder implements View.OnClickListener {

	public AbstractRecyclerViewViewholder (@NonNull View itemView) {
		super(itemView);
		setOnClickListeners();
		setViews();
	}

	public void setOnClickListeners () {
		itemView.setOnClickListener(this);
	}
	public abstract void setViews ();
	public abstract void bind (T t);
}

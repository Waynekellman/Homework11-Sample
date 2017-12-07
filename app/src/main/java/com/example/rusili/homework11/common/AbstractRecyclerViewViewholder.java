package com.example.rusili.homework11.common;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;


//	Abstracted the Viewholder to include an OnClickListener so I don't have to implement that for each one.
//	In addition, I save the context so I can create intents quicker and create my setVIew and bind methods for quicker Viewholder creation
public abstract class AbstractRecyclerViewViewholder <T> extends RecyclerView.ViewHolder implements View.OnClickListener {
	private Context context;	// Saves reference to its context
	private Resources resources;		// Saves reference to resources so I can call getString quickly.

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
		itemView.setOnClickListener(this);		//	I make the whole itemview clickable by default, but I keep it public so it can be overridden at any time.
	}
	public abstract void setViews ();		//	I like to set up my views in its own method
	public abstract void bind (T t);	//	I know I'm always going to need a bind method

	@NonNull
	protected Context getContext () {
		return context;
	}

	@NonNull
	protected Resources getResources () {
		return resources;
	}
}

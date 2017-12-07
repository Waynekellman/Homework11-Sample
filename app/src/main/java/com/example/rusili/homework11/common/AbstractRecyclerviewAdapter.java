package com.example.rusili.homework11.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

// 	My Abstract Recycerlview Adapter which uses Generics to be able to take in any type of Object
//	Gets rid of the getItemCount method as well as the onCreateViewholder inflation code.
public abstract class AbstractRecyclerviewAdapter <T> extends RecyclerView.Adapter <AbstractRecyclerViewViewholder> {
	public List <T> list;	// My generic list. It will hold any type of object.
	public View view;	// Holds reference to the viewholder view.

	public AbstractRecyclerviewAdapter (@Nullable List <T> list) {
		this.list = list;
	}

	@Override
	@NonNull
	public AbstractRecyclerViewViewholder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
		view = LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false);
		return getViewholder();
	}
	protected abstract AbstractRecyclerViewViewholder getViewholder ();
	public abstract int getLayout ();

	@Override
	public void onBindViewHolder (@NonNull AbstractRecyclerViewViewholder holder, int position) {
		if (!list.isEmpty()) {
			holder.bind(list.get(position));
		}
	}

	// 	I give the adapter the ability to update its list after it's set in the constructor, but I have no need for it in this project.
	public void setList (@NonNull List <T> list) {
		this.list = list;
	}

	//	This gets rid of the getItemCount method from the adapters which extend this class. It's annoying to look at.
	@Override
	public int getItemCount () {
		if (!list.isEmpty()) {
			return list.size();
		} else {
			return 0;
		}
	}
}

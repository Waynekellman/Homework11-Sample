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
	public List <T> list;
	public View view;

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

	public void setList (@NonNull List <T> list) {
		this.list = list;
	}

	@Override
	public int getItemCount () {
		if (!list.isEmpty()) {
			return list.size();
		} else {
			return 0;
		}
	}
}

package com.example.rusili.homework11.pokedexActivity.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.GameGroup;
import com.example.rusili.homework11.pokedexActivity.view.viewholder.GameViewholder;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameViewholder> {
	private List<GameGroup> gamesList = new ArrayList<>();

	public GameAdapter(List<GameGroup> gameGroupList){
		this.gamesList = gameGroupList;
	}

	@Override
	public GameViewholder onCreateViewHolder (ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_viewholder, parent, false);
		return new GameViewholder(view);
	}

	@Override
	public void onBindViewHolder (GameViewholder holder, int position) {
		holder.bind(gamesList.get(position));
	}

	@Override
	public int getItemCount () {
		return gamesList.size();
	}
}

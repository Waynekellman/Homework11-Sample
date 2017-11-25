package com.example.rusili.homework11.pokedexActivity.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.example.rusili.homework11.pokedexActivity.view.viewholder.PokemonViewholder;

import java.util.ArrayList;
import java.util.List;

public class PokedexAdapter extends RecyclerView.Adapter<PokemonViewholder> {
	private List<PokemonEntries> pokedex = new ArrayList<>();

	public PokedexAdapter (List<PokemonEntries> gameList){
		this.pokedex = gameList;
	}

	@Override
	public PokemonViewholder onCreateViewHolder (ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_viewholder, parent, false);
		return new PokemonViewholder(view);
	}

	@Override
	public void onBindViewHolder (PokemonViewholder holder, int position) {
		holder.bind(pokedex.get(position));
	}

	@Override
	public int getItemCount () {
		return pokedex.size();
	}
}

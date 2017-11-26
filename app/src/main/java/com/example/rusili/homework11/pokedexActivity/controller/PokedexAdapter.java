package com.example.rusili.homework11.pokedexActivity.controller;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.common.AbstractRecyclerviewAdapter;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.example.rusili.homework11.pokedexActivity.view.viewholder.PokemonRecyclerViewViewholder;

import java.util.List;

public class PokedexAdapter extends AbstractRecyclerviewAdapter<PokemonEntries> {

	public PokedexAdapter (List <PokemonEntries> list) {
		super(list);
	}

	@Override
	protected AbstractRecyclerViewViewholder getViewholder () {
		return  new PokemonRecyclerViewViewholder(view);
	}

	@Override
	public int getLayout () {
		return R.layout.pokemon_viewholder;
	}
}

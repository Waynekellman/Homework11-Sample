package com.example.rusili.homework11.pokedexscreen.controller;

import android.support.annotation.NonNull;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.common.AbstractRecyclerviewAdapter;
import com.example.rusili.homework11.pokedexscreen.model.objects.PokemonEntries;
import com.example.rusili.homework11.pokedexscreen.view.viewholder.PokemonRecyclerViewViewholder;

import java.util.List;

// See how empty my adapter is when I move so much of the code to the Abstract one.
public class PokedexAdapter extends AbstractRecyclerviewAdapter<PokemonEntries> {

	public PokedexAdapter (@NonNull List <PokemonEntries> list) {super(list);}

	@Override
	protected AbstractRecyclerViewViewholder getViewholder () {
		return  new PokemonRecyclerViewViewholder(view);
	}

	@Override
	public int getLayout () {
		return R.layout.pokemon_viewholder;
	}
}

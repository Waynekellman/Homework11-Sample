package com.example.rusili.homework11.pokedexActivity.view.viewholder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

public class PokemonViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
	private TextView number;
	private TextView name;

	private PokemonEntries pokemon;

	public PokemonViewholder (View itemView) {
		super(itemView);
		setViews();
	}

	private void setViews () {
		number = itemView.findViewById(R.id.pokemon_id);
		name = itemView.findViewById(R.id.pokemon_name);
	}

	public void bind (PokemonEntries pokemonEntries) {
		number.setText(String.valueOf(pokemonEntries.getEntry_number()));
		name.setText(pokemonEntries.getPokemon_species().getName());
		name.setOnClickListener(this);
	}

	@Override
	public void onClick (View view) {
		toDetailActivity(view.getContext());
	}

	private void toDetailActivity (Context context) {
		Intent toDetailActivity = new Intent(context, PokemonDetailActivity.class);
		toDetailActivity.putExtra("pokemonName", name.getText());
		context.startActivity(toDetailActivity);
	}
}

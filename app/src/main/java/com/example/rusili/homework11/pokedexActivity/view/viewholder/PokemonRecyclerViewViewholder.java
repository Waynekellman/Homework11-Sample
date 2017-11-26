package com.example.rusili.homework11.pokedexActivity.view.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.detailscreen.view.PokemonActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

public class PokemonRecyclerViewViewholder extends AbstractRecyclerViewViewholder<PokemonEntries> {
	private TextView number;
	private TextView name;

	public PokemonRecyclerViewViewholder (View itemView) {
		super(itemView);
	}

	@Override
	public void setViews () {
		number = itemView.findViewById(R.id.pokemon_id);
		name = itemView.findViewById(R.id.pokemon_name);
	}

	@Override
	public void bind (PokemonEntries pokemonEntries) {
		number.setText(String.valueOf(pokemonEntries.getEntry_number()));
		name.setText(pokemonEntries.getPokemon_species().getName());
	}

	@Override
	public void onClick (View view) {
		toDetailActivity();
	}

	private void toDetailActivity () {
		Intent toDetailActivity = new Intent(getContext(), PokemonActivity.class);
		toDetailActivity.putExtra(getResources().getString(R.string.INTENT_STRING_EXTRA_POKEMON_NAME), name.getText());
		getContext().startActivity(toDetailActivity);
	}
}

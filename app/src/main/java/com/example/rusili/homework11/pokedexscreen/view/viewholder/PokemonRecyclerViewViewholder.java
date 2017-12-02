package com.example.rusili.homework11.pokedexscreen.view.viewholder;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.common.NetworkConnectivity;
import com.example.rusili.homework11.detailscreen.view.PokemonActivity;
import com.example.rusili.homework11.pokedexscreen.model.objects.PokemonEntries;

public class PokemonRecyclerViewViewholder extends AbstractRecyclerViewViewholder<PokemonEntries> {
	private TextView number;
	private TextView name;
	private ImageView sprite;

	public PokemonRecyclerViewViewholder (View itemView) {
		super(itemView);
	}

	@Override
	public void setViews () {
		number = itemView.findViewById(R.id.pokemon_id);
		name = itemView.findViewById(R.id.pokemon_name);
		sprite = itemView.findViewById(R.id.pokemon_viewholder_sprite);
	}

	@Override
	public void bind (PokemonEntries pokemonEntries) {
		number.setText(String.valueOf(pokemonEntries.getEntry_number()));
		String nameString = pokemonEntries.getPokemon_species().getName();
		Character firstLetter = Character.toUpperCase(nameString.charAt(0));
		name.setText(firstLetter + nameString.substring(1));

		Glide.with(itemView)
			  .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemonEntries.getEntry_number() + ".png")
			  .into(sprite);
	}

	@Override
	public void onClick (View view) {
		toDetailActivity();
	}

	private void toDetailActivity () {
		if (NetworkConnectivity.isConnected(getContext())){
			Intent toDetailActivity = new Intent(getContext(), PokemonActivity.class);
			toDetailActivity.putExtra(getResources().getString(R.string.INTENT_STRING_EXTRA_POKEMON_NAME), name.getText().toString().toLowerCase());
			getContext().startActivity(toDetailActivity);
		} else {
			Snackbar.make(itemView,
				  getResources().getString(R.string.no_network_connectivity), Snackbar.LENGTH_LONG)
				  .show();
		}
	}
}

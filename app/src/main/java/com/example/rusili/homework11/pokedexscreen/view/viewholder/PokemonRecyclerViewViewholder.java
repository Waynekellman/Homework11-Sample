package com.example.rusili.homework11.pokedexscreen.view.viewholder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.util.NetworkConnectivity;
import com.example.rusili.homework11.detailscreen.view.PokemonActivity;
import com.example.rusili.homework11.pokedexscreen.model.objects.PokemonEntries;
import com.example.rusili.homework11.util.TextHelper;

public class PokemonRecyclerViewViewholder extends AbstractRecyclerViewViewholder<PokemonEntries> {
	private TextView number, name;
	private ImageView sprite;

	private String capitalizedPokemonName;

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
	public void bind (@NonNull PokemonEntries pokemonEntries) {
		capitalizedPokemonName = TextHelper.capitalizeFirstLetter(pokemonEntries.getPokemon_species().getName());
		String id = getPokemonId(pokemonEntries);

		number.setText(id);
		name.setText(capitalizedPokemonName);

		Glide.with(itemView)
			  .load(getResources().getString(R.string.viewholder_pokemon_icon_url, id))
			  .into(sprite);
	}

	@Nullable
	private String getPokemonId (@NonNull PokemonEntries pokemonEntries) {
		String url = pokemonEntries.getPokemon_species().getUrl();
		String toRemove = getResources().getString(R.string.glide_pokemon_sprite_url_to_remove);
		return url.replace(toRemove, "")
			  .replace("/", "");
	}

	@Override
	public void onClick (View view) {
		toDetailActivity();
	}

	private void toDetailActivity () {
		if (NetworkConnectivity.isConnected(getContext())){
			Intent toDetailActivity = new Intent(getContext(), PokemonActivity.class);
			toDetailActivity.putExtra(getResources().getString(R.string.INTENT_STRING_EXTRA_POKEMON_NAME), capitalizedPokemonName);
			getContext().startActivity(toDetailActivity);
		} else {
			Snackbar.make(itemView,
				  getResources().getString(R.string.no_network_connectivity), Snackbar.LENGTH_LONG)
				  .show();
		}
	}
}

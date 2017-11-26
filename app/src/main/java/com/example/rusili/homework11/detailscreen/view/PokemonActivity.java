package com.example.rusili.homework11.detailscreen.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.FragmentAbstractActivity;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.network.RetrofitFactory;

public class PokemonActivity extends FragmentAbstractActivity {
	private String pokemonName;

	private TextView name;
	private TextView type1;
	private TextView type2;
	private ImageView sprite;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity_layout);
		showLoadingFragment();

		pokemonName = getIntent().getStringExtra(getString(R.string.INTENT_STRING_EXTRA_POKEMON_NAME));
		initialize();
	}

	private void initialize () {
		setViews();
		getPokemonDetails();
	}

	private void getPokemonDetails () {
		RetrofitFactory.PokemonNetworkListener pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {
				showPokemonData(pokemon);
				hideLoadingFragment();
			}
		};

		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName);
	}

	private void showPokemonData (Pokemon pokemon) {
		name.setText(pokemonName);
		type1.setText(pokemon.getTypes()[0].getType().getName());
		if (pokemon.getTypes().length > 1) {
			type2.setText(pokemon.getTypes()[1].getType().getName());
		}
		Glide.with(this)
			  .load(pokemon.getSprites().getBack_default())
			  .into(sprite);
	}

	private void setViews () {
		name = findViewById(R.id.detail_name);
		type1 = findViewById(R.id.detail_type1);
		type2 = findViewById(R.id.detail_type2);
		sprite = findViewById(R.id.detail_sprite);
	}
}

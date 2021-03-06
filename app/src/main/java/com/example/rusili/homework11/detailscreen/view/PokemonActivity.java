package com.example.rusili.homework11.detailscreen.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.FragmentAbstractActivity;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.TypeEnum;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.util.TextHelper;

public class PokemonActivity extends FragmentAbstractActivity {
	private View header_include, stats_include;
	private TextView name, id, type1,type2;
	private ImageView sprite;
	private ProgressBar hp, attack, defense, spAtk, spDef, speed;

	private String pokemonName;

	@Override
	public void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		showLoadingFragment();	// I show my loading fragment as soon as this activity is created so it will show on top and not below it.

		pokemonName = getIntent().getStringExtra(getString(R.string.INTENT_STRING_EXTRA_POKEMON_NAME));
		initialize();
	}

	@Override
	protected int getLayoutId () {
		return R.layout.detail_activity_layout;
	}

	private void initialize () {
		setViews();
		getPokemonDetails();
	}

	private void setViews () {
		setTitle(pokemonName);	// Sets the String in the action bar.

		setHeaderViews();
		setStatsViews();
	}

	private void setHeaderViews () {
		header_include = findViewById(R.id.pokemon_include_header_layout);
		name = header_include.findViewById(R.id.pokemon_detail_name);
		id = header_include.findViewById(R.id.pokemon_detail_id);
		type1 = header_include.findViewById(R.id.pokemon_detail_type_1);
		type2 = header_include.findViewById(R.id.pokemon_detail_type_2);
		sprite = header_include.findViewById(R.id.pokemon_detail_sprite);
	}

	private void setStatsViews () {
		stats_include = findViewById(R.id.pokemon_include_stats_layout);
		hp = stats_include.findViewById(R.id.pokemon_stat_hp);
		attack = stats_include.findViewById(R.id.pokemon_stat_atk);
		defense = stats_include.findViewById(R.id.pokemon_stat_def);
		spAtk = stats_include.findViewById(R.id.pokemon_stat_spatk);
		spDef = stats_include.findViewById(R.id.pokemon_stat_spdef);
		speed = stats_include.findViewById(R.id.pokemon_stat_speed);
	}

	private void getPokemonDetails () {
		RetrofitFactory.PokemonNetworkListener pokemonNetworkListener = new RetrofitFactory.PokemonNetworkListener() {
			@Override
			public void pokemonCallback (Pokemon pokemon) {
				showHeaderData(pokemon);
				showStatsData(pokemon);
				hideLoadingFragment();	// I hide the loading fragment only after my network call is successful.
			}
			@Override
			public void onErrorCallback (Throwable t) {
				Snackbar.make(findViewById(android.R.id.content), R.string.network_error, Snackbar.LENGTH_LONG).show();
				hideLoadingFragment();	//	Or if it fails
			}
		};
		RetrofitFactory.getInstance().setPokemonNetworkListener(pokemonNetworkListener);
		RetrofitFactory.getInstance().getPokemon(pokemonName.toLowerCase());
	}

	private void showHeaderData (@NonNull Pokemon pokemon) {
		header_include.setVisibility(View.VISIBLE);	// I set my views to be invisible at the start because the static Strings will be visible beneath the loading fragment, which I didn't want.

		name.setText(pokemonName);
		id.setText(String.valueOf(pokemon.getId()));

		String type = pokemon.getTypes()[0].getType().getName();
		type1.setText(TextHelper.capitalizeFirstLetter(type));
		type1.setBackgroundColor(getResources().getColor(TypeEnum.getColorResource(type)));
		if (pokemon.getTypes().length > 1) {
			type = pokemon.getTypes()[1].getType().getName();
			type2.setText(TextHelper.capitalizeFirstLetter(type));
			type2.setBackgroundColor(getResources().getColor(TypeEnum.getColorResource(type)));
		}

		if (!PokemonActivity.this.isFinishing()) {	// This is needed so the app doesn't crash when navigating away from the activity while Glide is still trying to load the image.
			Glide.with(this)
				  .load(pokemon.getSprites().getFront_default())
				  .into(sprite);
		}
	}

	private void showStatsData (@NonNull Pokemon pokemon) {
		stats_include.setVisibility(View.VISIBLE);		// I set my views to be invisible at the start because the static Strings will be visible beneath the loading fragment, which I didn't want.

		hp.setProgress(pokemon.getStats()[5].getBase_stat());
		attack.setProgress(pokemon.getStats()[4].getBase_stat());
		defense.setProgress(pokemon.getStats()[3].getBase_stat());
		spAtk.setProgress(pokemon.getStats()[2].getBase_stat());
		spDef.setProgress(pokemon.getStats()[1].getBase_stat());
		speed.setProgress(pokemon.getStats()[0].getBase_stat());
	}
}

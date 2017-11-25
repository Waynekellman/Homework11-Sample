package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.view.fragments.GameListFragment;
import com.example.rusili.homework11.pokedexActivity.view.fragments.PokedexFragment;

public class PokedexGeneralActivity extends AppCompatActivity {

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokedex_activity_layout);

		setupStartFragment();
	}

	private void setupStartFragment () {
		showGameListFragment();
	}

	private void showGameListFragment () {
		getSupportFragmentManager().beginTransaction()
			  .replace(R.id.pokedex_activity_container, GameListFragment.getInstance())
			  .addToBackStack(null)
			  .commit();
	}

	private void showPokedexFragment () {
		getSupportFragmentManager().beginTransaction()
			  .replace(R.id.pokedex_activity_container, PokedexFragment.getInstance())
			  .addToBackStack(null)
			  .commit();
	}
}

package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.view.fragments.GameListFragment;
import com.example.rusili.homework11.pokedexActivity.view.fragments.PokedexFragment;

public class PokedexGeneralActivity extends AppCompatActivity {
	private final FragmentManager fragmentManager = getSupportFragmentManager();

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
		fragmentManager.beginTransaction()
			  .replace(R.id.pokedex_activity_container, new GameListFragment())
			  .addToBackStack(null)
			  .commit();
	}

	public void showPokedexFragment (int pokedexID) {
		PokedexFragment pokedexFragment = new PokedexFragment();
		pokedexFragment.setPokedexId(pokedexID);

		fragmentManager.beginTransaction()
			  .replace(R.id.pokedex_activity_container, pokedexFragment)
			  .addToBackStack(null)
			  .commit();
	}
}

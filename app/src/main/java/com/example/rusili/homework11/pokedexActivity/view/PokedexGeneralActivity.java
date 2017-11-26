package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.FragmentAbstractActivity;
import com.example.rusili.homework11.pokedexActivity.view.fragments.GameListFragment;
import com.example.rusili.homework11.pokedexActivity.view.fragments.PokedexFragment;

public class PokedexGeneralActivity extends FragmentAbstractActivity {

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokedex_activity_layout);

		setupStartFragment();
	}

	private void setupStartFragment () {
		showGameListFragment();
	}

	private void showGameListFragment () {
		showFragment(new GameListFragment());
	}

	public void showPokedexFragment (int pokedexID) {
		PokedexFragment pokedexFragment = new PokedexFragment();
		pokedexFragment.setPokedexId(pokedexID);

		showFragment(pokedexFragment);
	}
}

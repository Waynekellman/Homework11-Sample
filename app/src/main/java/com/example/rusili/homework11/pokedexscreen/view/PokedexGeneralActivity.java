package com.example.rusili.homework11.pokedexscreen.view;

import android.os.Bundle;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.FragmentAbstractActivity;
import com.example.rusili.homework11.pokedexscreen.view.fragments.GameListFragment;
import com.example.rusili.homework11.pokedexscreen.view.fragments.PokedexFragment;

public class PokedexGeneralActivity extends FragmentAbstractActivity {

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setupStartFragment();
	}

	@Override
	protected int getLayoutId() {
		return R.layout.pokedex_activity_layout;
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

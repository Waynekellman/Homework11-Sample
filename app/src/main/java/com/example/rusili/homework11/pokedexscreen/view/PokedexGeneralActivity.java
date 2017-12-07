package com.example.rusili.homework11.pokedexscreen.view;

import android.os.Bundle;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.FragmentAbstractActivity;
import com.example.rusili.homework11.pokedexscreen.view.fragments.GameListFragment;
import com.example.rusili.homework11.pokedexscreen.view.fragments.PokedexFragment;
import com.example.rusili.homework11.util.NetworkConnectivity;

//	Extends my Abstract Fragment Activity
public class PokedexGeneralActivity extends FragmentAbstractActivity {

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// As you can see, there's no setContentView here. Instead, I get my layout from getLayoutId to pass to the Abstract Activity.

		setupStartFragment();
	}

	@Override
	protected int getLayoutId () {
		return R.layout.pokedex_activity_layout;
	}

	private void setupStartFragment () {
		showGameListFragment();
	}

	private void showGameListFragment () {
		showFragment(new GameListFragment());	//	All I need to show my fragment is give it a new Fragment, and my showFragment method from my Abstract Activity does all the rest.
	}

	public void showPokedexFragment (int pokedexID) {		//	This method does a network check BEFORE I show the fragment. If there's no network, it doesn't go.
		if (NetworkConnectivity.isConnected(this)) {
			PokedexFragment pokedexFragment = new PokedexFragment();
			pokedexFragment.setPokedexId(pokedexID);
			showFragment(pokedexFragment);
		} else {
			showSnackbar(getString(R.string.no_network_connectivity));
		}
	}
}

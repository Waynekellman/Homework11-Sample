package com.example.rusili.homework11.pokedexscreen.view.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractFragment;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexscreen.controller.PokedexAdapter;
import com.example.rusili.homework11.pokedexscreen.model.Pokedex;
import com.example.rusili.homework11.pokedexscreen.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PokedexFragment extends AbstractFragment {
	private RecyclerView pokedexRecyclerView;

	private int pokedexId;

	@Override
	public int getLayoutId () {
		return R.layout.pokedex_fragment_layout;
	}

	@Override
	public void onCreateView () {
		checkSharedPrefs();
		getParentActivity().showLoadingFragment();
		setViews();
		getPokedexList();
	}

	private void checkSharedPrefs() {

	}

	private void setViews () {
		getParentActivity().setTitle("Generation: " + String.valueOf(pokedexId - 1));

		pokedexRecyclerView = parentView.findViewById(R.id.pokedex_recyclerview);
		pokedexRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		pokedexRecyclerView.setHasFixedSize(true);
		pokedexRecyclerView.setAdapter(null);
	}

	private void getPokedexList () {
		RetrofitFactory.PokedexNetworkListener pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				List <PokemonEntries> pokemonList = new ArrayList <>();
				Collections.addAll(pokemonList, pokedex.getPokemonEntries());

				saveToSharedPrefs(new HashSet(pokemonList));

				pokedexRecyclerView.setAdapter(new PokedexAdapter(pokemonList));
				getParentActivity().hideLoadingFragment();
			}
		};
		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex(pokedexId);
	}

	private void saveToSharedPrefs(HashSet pokemonSet) {
		SharedPreferences sharedpreferences = getContext().getSharedPreferences("Pokedex", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedpreferences.edit();

		editor.putStringSet(String.valueOf(pokedexId), pokemonSet);
		editor.apply();
	}

	public void setPokedexId (int pokedexID) {
		this.pokedexId = pokedexID;
	}
}

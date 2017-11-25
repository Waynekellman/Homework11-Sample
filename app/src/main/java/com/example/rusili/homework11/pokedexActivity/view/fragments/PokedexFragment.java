package com.example.rusili.homework11.pokedexActivity.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.controller.PokedexAdapter;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
	private static PokedexFragment pokedexFragment;

	private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;

	private View parentView;
	private RecyclerView pokedexRecyclerView;

	public static PokedexFragment getInstance () {
		if (pokedexFragment == null) {
			pokedexFragment = new PokedexFragment();
		}
		return pokedexFragment;
	}

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.pokedex_fragment_layout, container, false);
		setViews();
		getPokedexList();
		return parentView;
	}

	private void setViews () {
		pokedexRecyclerView = parentView.findViewById(R.id.pokedex_recyclerview);
		pokedexRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				Log.d("Pokedex: ", pokedex.getRegion().getName());

				List<PokemonEntries> pokemonList = new ArrayList<>();
				Collections.addAll(pokemonList, pokedex.getPokemonEntries());

				pokedexRecyclerView.setAdapter(new PokedexAdapter(pokemonList));
			}
		};

		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex();
	}

}

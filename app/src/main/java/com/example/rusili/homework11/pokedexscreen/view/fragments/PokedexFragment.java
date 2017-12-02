package com.example.rusili.homework11.pokedexscreen.view.fragments;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractFragment;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexscreen.controller.PokedexAdapter;
import com.example.rusili.homework11.pokedexscreen.model.Pokedex;
import com.example.rusili.homework11.pokedexscreen.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokedexFragment extends AbstractFragment {
    private RecyclerView pokedexRecyclerView;

    private int pokedexId;

    @Override
    public int getLayoutId() {
        return R.layout.pokedex_fragment_layout;
    }

    @Override
    public void onCreateView() {
        getParentActivity().showLoadingFragment();
        setViews();
        getPokedexList();
    }

    private void setViews() {
        getParentActivity().setTitle("Generation: " + String.valueOf(pokedexId - 1));

        pokedexRecyclerView = parentView.findViewById(R.id.pokedex_recyclerview);
        pokedexRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        pokedexRecyclerView.setHasFixedSize(true);
        pokedexRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        pokedexRecyclerView.setItemAnimator(new DefaultItemAnimator());
        pokedexRecyclerView.setAdapter(null);
    }

    private void getPokedexList() {
        RetrofitFactory.PokedexNetworkListener pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback(Pokedex pokedex) {
                List<PokemonEntries> pokemonList = new ArrayList<>();
                Collections.addAll(pokemonList, pokedex.getPokemonEntries());

                setPokedexAdapter(pokemonList);
            }

            @Override
            public void onErrorCallback (Throwable t) {
                Snackbar.make(parentView, R.string.network_error, Snackbar.LENGTH_LONG).show();
            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(pokedexId);
    }

    private void setPokedexAdapter(List<PokemonEntries> pokemonList) {
        pokedexRecyclerView.setAdapter(new PokedexAdapter(pokemonList));
        getParentActivity().hideLoadingFragment();
    }

    public void setPokedexId(int pokedexID) {
        this.pokedexId = pokedexID;
    }
}

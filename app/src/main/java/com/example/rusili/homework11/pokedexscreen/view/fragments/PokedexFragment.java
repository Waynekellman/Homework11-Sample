package com.example.rusili.homework11.pokedexscreen.view.fragments;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
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
        getParentActivity().showLoadingFragment();  // I show the loading fragment as soon as this fragment's view is created so the loading fragment will be on TOP of it and not below it.
        setViews();
        getPokedexList();
    }

    private void setViews() {
        getParentActivity().setTitle(getResources().getString(R.string.game_generation_text) + " " + String.valueOf(pokedexId - 1));    // Set title changes the String in the action bar. Need reference to the parent activity because the action bar belongs to that.

        pokedexRecyclerView = parentView.findViewById(R.id.pokedex_recyclerview);
        pokedexRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL)); //  This is what creates the gray lines in between my viewholders
        pokedexRecyclerView.setHasFixedSize(true);
        pokedexRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void getPokedexList() {
        RetrofitFactory.PokedexNetworkListener pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback(Pokedex pokedex) {
                List<PokemonEntries> pokemonList = new ArrayList<>();
                Collections.addAll(pokemonList, pokedex.getPokemonEntries());

                setPokedexAdapter(pokemonList);
                getParentActivity().hideLoadingFragment();  //  Only after my network call is done and I've gotten all my information do I remove my loading fragment. You can see why getting reference to the parent activity is useful here.
            }

            @Override
            public void onErrorCallback (Throwable t) {
                Snackbar.make(parentView, R.string.network_error, Snackbar.LENGTH_LONG).show();
                getParentActivity().hideLoadingFragment();	//	Or if it fails
            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(pokedexId);
    }

    private void setPokedexAdapter(@NonNull List<PokemonEntries> pokemonList) {
        pokedexRecyclerView.setAdapter(new PokedexAdapter(pokemonList));
    }

    public void setPokedexId (int pokedexId) {
        this.pokedexId = pokedexId;
    }
}

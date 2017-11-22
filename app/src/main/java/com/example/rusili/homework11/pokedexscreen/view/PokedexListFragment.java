package com.example.rusili.homework11.pokedexscreen.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexscreen.model.Pokedex;

import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexListFragment extends Fragment{
    private static PokedexListFragment pokedexListFragment;

    private RetrofitFactory.PokedexListNetworkListener pokedexListNetworkListener;

    public static PokedexListFragment getInstance(){
        if (pokedexListFragment == null){
            pokedexListFragment = new PokedexListFragment();
        }
        return pokedexListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = ;

        return view;
    }

    private void getPokedexList(){
        pokedexListNetworkListener = new RetrofitFactory.PokedexListNetworkListener() {
            @Override
            public void pokedexListCallback(List<Pokedex> pokedex) {
                // Show list of pokedexes
            }
        };

        RetrofitFactory.getInstance().setPokedexListNetworkListener(pokedexListNetworkListener);
        RetrofitFactory.getInstance().getPokedexList();
    }
}

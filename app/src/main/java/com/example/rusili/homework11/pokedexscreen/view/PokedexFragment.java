package com.example.rusili.homework11.pokedexscreen.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexscreen.model.Pokedex;

import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment{
    private static PokedexFragment pokedexFragment;

    private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;

    public static PokedexFragment getInstance(){
        if (pokedexFragment == null){
            pokedexFragment = new PokedexFragment();
        }
        return pokedexFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = ;

        return view;
    }

    private void getPokedexList(){
        pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback(Pokedex pokedex) {
                // Show pokedex
            }
        };

        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex();
    }

}

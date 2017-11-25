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
import com.example.rusili.homework11.pokedexActivity.controller.GameAdapter;
import com.example.rusili.homework11.pokedexActivity.model.PokemonGames;
import com.example.rusili.homework11.pokedexActivity.model.objects.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class GameListFragment extends Fragment{
    private static GameListFragment gameListFragment;
    private RetrofitFactory.GameListNetworkListener gameListNetworkListener;

    private View parentView;
    private RecyclerView gameRecyclerView;

    public static GameListFragment getInstance(){
        if (gameListFragment == null){
            gameListFragment = new GameListFragment();
        }
        return gameListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.game_list_fragment_layout, container, false);
        initialize();
        return parentView;
    }

    private void initialize () {
        setViews();
        getGamesList();
    }

    private void setViews () {
        gameRecyclerView = parentView.findViewById(R.id.pokemon_games_recycler_view);
        gameRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void getGamesList(){
        gameListNetworkListener = new RetrofitFactory.GameListNetworkListener() {
            @Override
            public void gamesListCallback (PokemonGames games) {
                Log.d("gamesListCallback: ", games.getResults()[1].getName());

                List<Game> gameList = new ArrayList <>();
                Collections.addAll(gameList, games.getResults());

                gameRecyclerView.setAdapter(new GameAdapter(gameList));
            }
        };

        RetrofitFactory.getInstance().setGameListNetworkListener(gameListNetworkListener);
        RetrofitFactory.getInstance().getGameList();
    }
}

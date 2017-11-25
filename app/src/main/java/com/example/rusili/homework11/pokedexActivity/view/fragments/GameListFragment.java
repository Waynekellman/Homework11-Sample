package com.example.rusili.homework11.pokedexActivity.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.controller.GameAdapter;
import com.example.rusili.homework11.pokedexActivity.model.GameGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class GameListFragment extends Fragment {
	private View parentView;
	private RecyclerView gameRecyclerView;

	private List <GameGroup> gameGroupList = new ArrayList <>();

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.game_list_fragment_layout, container, false);
		initialize();
		return parentView;
	}

	private void initialize () {
		if (gameGroupList.isEmpty()) {
			createGamesList();
		}
		setViews();
	}

	private void createGamesList () {
		gameGroupList.add(new GameGroup(2, "I", "Blue", "Red", "Yellow"));
		gameGroupList.add(new GameGroup(3, "II", "Silver", "Gold", "Crystal"));
		gameGroupList.add(new GameGroup(4, "III", "Ruby", "Sapphire", "Emerald"));
		gameGroupList.add(new GameGroup(5, "IV", "Diamond", "Pearl"));
	}

	private void setViews () {
		gameRecyclerView = parentView.findViewById(R.id.pokemon_games_recycler_view);
		gameRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		gameRecyclerView.setAdapter(new GameAdapter(gameGroupList));
	}
}

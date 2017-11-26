package com.example.rusili.homework11.pokedexActivity.view.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractFragment;
import com.example.rusili.homework11.pokedexActivity.controller.GameAdapter;
import com.example.rusili.homework11.pokedexActivity.model.GameGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class GameListFragment extends AbstractFragment {

	private List <GameGroup> gameGroupList = new ArrayList <>();

	@Override
	public int getLayoutId () {
		return R.layout.game_list_fragment_layout;
	}

	@Override
	public void onCreateView () {
		initialize();
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
		RecyclerView gameRecyclerView = parentView.findViewById(R.id.pokemon_games_recycler_view);
		gameRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		gameRecyclerView.setAdapter(new GameAdapter(gameGroupList));
	}
}

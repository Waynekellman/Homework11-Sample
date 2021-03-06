package com.example.rusili.homework11.pokedexscreen.view.fragments;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractFragment;
import com.example.rusili.homework11.pokedexscreen.controller.GameAdapter;
import com.example.rusili.homework11.pokedexscreen.model.GameGroup;

import java.util.ArrayList;
import java.util.List;

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

	// I created my own GameGroups because the PokeApi is annoying.
	private void createGamesList () {
		gameGroupList.add(new GameGroup(2, "I", "Blue", "Red", "Yellow"));
		gameGroupList.add(new GameGroup(3, "II", "Silver", "Gold", "Crystal"));
		gameGroupList.add(new GameGroup(4, "III", "Ruby", "Sapphire", "Emerald"));
		gameGroupList.add(new GameGroup(5, "IV", "Diamond", "Pearl"));
	}

	private void setViews () {
		getParentActivity().setTitle(R.string.game_generation_text);	// Setting the title again.

		RecyclerView gameRecyclerView = parentView.findViewById(R.id.pokemon_games_recycler_view);
		gameRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));	// Shows the gray dividers between each viewholder. All you need is this line.
		gameRecyclerView.setHasFixedSize(true);
		gameRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		gameRecyclerView.setAdapter(new GameAdapter(gameGroupList));
	}
}

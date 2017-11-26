package com.example.rusili.homework11.pokedexActivity.controller;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.common.AbstractRecyclerviewAdapter;
import com.example.rusili.homework11.pokedexActivity.model.GameGroup;
import com.example.rusili.homework11.pokedexActivity.view.viewholder.GameRecyclerViewViewholder;

import java.util.List;

public class GameAdapter extends AbstractRecyclerviewAdapter<GameGroup> {

	public GameAdapter (List <GameGroup> list) {
		super(list);
	}

	@Override
	protected AbstractRecyclerViewViewholder getViewholder () {
		return new GameRecyclerViewViewholder(view);
	}

	@Override
	public int getLayout () {
		return R.layout.game_viewholder;
	}
}

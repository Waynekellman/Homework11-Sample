package com.example.rusili.homework11.pokedexscreen.controller;

import android.support.annotation.NonNull;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.common.AbstractRecyclerviewAdapter;
import com.example.rusili.homework11.pokedexscreen.model.GameGroup;
import com.example.rusili.homework11.pokedexscreen.view.viewholder.GameRecyclerViewViewholder;

import java.util.List;

public class GameAdapter extends AbstractRecyclerviewAdapter<GameGroup> {

	public GameAdapter (@NonNull List <GameGroup> list) {
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
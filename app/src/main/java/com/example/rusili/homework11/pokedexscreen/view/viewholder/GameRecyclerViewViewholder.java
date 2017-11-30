package com.example.rusili.homework11.pokedexscreen.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.pokedexscreen.model.GameGroup;
import com.example.rusili.homework11.pokedexscreen.view.PokedexGeneralActivity;

public class GameRecyclerViewViewholder extends AbstractRecyclerViewViewholder<GameGroup> {
	private TextView gameTextView;

	private GameGroup gameGroup;

	public GameRecyclerViewViewholder (View itemView) {
		super(itemView);
	}

	@Override
	public void setViews () {
		gameTextView = itemView.findViewById(R.id.game_group);
	}

	@Override
	public void bind (GameGroup gameGroup) {
		this.gameGroup = gameGroup;

		String gamesString = createGamesString(gameGroup);
		gameTextView.setText(gamesString);
	}

	@NonNull
	private String createGamesString (GameGroup gameGroup) {
		StringBuilder gameStringBuilder = new StringBuilder();
		for (String game : gameGroup.getGameList()){
			gameStringBuilder.append(", ")
				  .append(game);
		}
		return gameStringBuilder.toString();
	}

	@Override
	public void onClick (View view) {
		showPokedexFragment();
	}

	private void showPokedexFragment () {
		if (gameGroup != null) {
			((PokedexGeneralActivity) getContext()).showPokedexFragment(gameGroup.getPokedexID());
		}
	}
}

package com.example.rusili.homework11.pokedexscreen.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractRecyclerViewViewholder;
import com.example.rusili.homework11.pokedexscreen.model.GameGroup;
import com.example.rusili.homework11.pokedexscreen.view.PokedexGeneralActivity;

public class GameRecyclerViewViewholder extends AbstractRecyclerViewViewholder<GameGroup>{
	private TextView gameTextView;
	private TextView generationBigTextView, generationCaptionTextView;

	private GameGroup gameGroup;

	public GameRecyclerViewViewholder (View itemView) {
		super(itemView);
		setOnClickListeners();
	}

	@Override
	public void setViews () {
		gameTextView = itemView.findViewById(R.id.game_group);
		generationBigTextView = itemView.findViewById(R.id.game_generation_big);
		generationCaptionTextView = itemView.findViewById(R.id.game_generation_caption);
	}

	@Override
	public void bind (GameGroup gameGroup) {
		this.gameGroup = gameGroup;

		generationBigTextView.setText(gameGroup.getGeneration());
		generationCaptionTextView.setText(new StringBuilder().append(getResources().getString(R.string.game_generation_text))
			  .append(" ")
			  .append(gameGroup.getGeneration()).toString());
		gameTextView.setText(createGamesString(gameGroup));
	}

	@NonNull
	private String createGamesString (GameGroup gameGroup) {
		StringBuilder gameStringBuilder = new StringBuilder(gameGroup.getGameList().get(0));
		for (String game : gameGroup.getGameList().subList(1, gameGroup.getGameList().size())){
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

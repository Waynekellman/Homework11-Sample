package com.example.rusili.homework11.pokedexActivity.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.GameGroup;
import com.example.rusili.homework11.pokedexActivity.view.PokedexGeneralActivity;

public class GameViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
	private TextView gameTextView;

	private GameGroup gameGroup;

	public GameViewholder (View itemView) {
		super(itemView);
		setViews();
	}

	private void setViews () {
		gameTextView = itemView.findViewById(R.id.game_textview);
		gameTextView.setOnClickListener(this);
	}

	public void bind (GameGroup gameGroup) {
		this.gameGroup = gameGroup;

		StringBuilder gameStringBuilder = new StringBuilder(gameGroup.getGameList().get(0));
		for (String game : gameGroup.getGameList()){
			gameStringBuilder.append(", ")
				  .append(game);
		}
		gameTextView.setText(gameStringBuilder);
	}

	@Override
	public void onClick (View view) {
		showPokedexFragment(view.getContext());
	}

	private void showPokedexFragment (Context context) {
		if (gameGroup != null) {
			((PokedexGeneralActivity) context).showPokedexFragment(gameGroup.getPokedexID());
		}
	}
}

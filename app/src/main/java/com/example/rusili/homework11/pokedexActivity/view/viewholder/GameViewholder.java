package com.example.rusili.homework11.pokedexActivity.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.objects.Game;

public class GameViewholder extends RecyclerView.ViewHolder {
	private TextView gameTextView;

	public GameViewholder (View itemView) {
		super(itemView);
		setViews();
	}

	private void setViews () {
		gameTextView = itemView.findViewById(R.id.game_textview);
	}

	public void bind (Game game) {
		gameTextView.setText(game.getName());
	}
}

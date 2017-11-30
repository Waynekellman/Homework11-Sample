package com.example.rusili.homework11.pokedexscreen.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameGroup {
	private int pokedexID;
	private String generation;
	private List<String> gameList = new ArrayList<>();

	public GameGroup (int id, String generation, String... games){
		this.pokedexID = id;
		this.generation = generation;
		Collections.addAll(gameList, games);
	}

	public int getPokedexID () {
		return pokedexID;
	}

	public String getGeneration () {
		return generation;
	}

	public List <String> getGameList () {
		return gameList;
	}
}

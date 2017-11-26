package com.example.rusili.homework11.pokedexActivity.api;

import com.example.rusili.homework11.pokedexActivity.model.Pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokedexApi {
	String pokedexEndpoint = "pokedex/{id}";
	String idPath = "id";

	@GET (pokedexEndpoint)
	Call <Pokedex> getPokedex (@Path (idPath) int id);
}
package com.example.rusili.homework11.pokedexscreen.api;

import com.example.rusili.homework11.pokedexscreen.model.Pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokedexApi {
	String pokedexEndpoint = "pokedex/{id}";		// Here I pull the Strings out into variables. No need to put in Resources.
	String idPath = "id";

	@GET (pokedexEndpoint)
	Call <Pokedex> getPokedex (@Path (idPath) int id);		// The @Path is used when your endpoint is dynamic and you want to pass in a variable at runtime.
}
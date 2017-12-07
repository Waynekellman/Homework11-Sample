package com.example.rusili.homework11.detailscreen.api;

import com.example.rusili.homework11.detailscreen.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rusi.li on 11/20/17.
 */

public interface PokemonApi {
	// Here I pull the Strings out into variables. No need to put in Resources.
	String pokemonNameEndpoint = "pokemon/{name}";
	String namePath = "name";

	@GET (pokemonNameEndpoint)
	Call <Pokemon> getPokemon (@Path (namePath) String pokemonName);
}
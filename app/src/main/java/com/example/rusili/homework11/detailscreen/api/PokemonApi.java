package com.example.rusili.homework11.detailscreen.api;

import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.PokemonSpecies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rusi.li on 11/20/17.
 */

public interface PokemonApi {
	String pokemonNameEndpoint = "pokemon/{name}";
	String pokemonSpeciesEndpoint = "pokemon-species/{name}";
	String namePath = "name";

	@GET (pokemonNameEndpoint)
	Call <Pokemon> getPokemon (@Path (namePath) String pokemonName);

	@GET (pokemonSpeciesEndpoint)
	Call <PokemonSpecies> getPokemonSpecies (@Path (namePath) String pokemonName);
}
package com.example.rusili.homework11.pokedexActivity.api;

import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.PokemonGames;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rusi.li on 11/20/17.
 */

public interface PokedexApi {

    @GET("pokedex/{id}")
    Call<Pokedex> getPokedex(@Path("id") int id);

    @GET("version-group/")
    Call<PokemonGames> getListOfGames ();
}
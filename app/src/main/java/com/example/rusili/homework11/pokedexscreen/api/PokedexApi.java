package com.example.rusili.homework11.pokedexscreen.api;

import com.example.rusili.homework11.pokedexscreen.model.Pokedex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rusi.li on 11/20/17.
 */

public interface PokedexApi {

    @GET("pokedex/2")
    Call<Pokedex> getPokedex();

    @GET("/pokedex")
    Call<List<Pokedex>> getListOfPokedexes();
}
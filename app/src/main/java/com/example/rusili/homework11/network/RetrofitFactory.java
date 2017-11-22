package com.example.rusili.homework11.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.rusili.homework11.detailscreen.api.PokemonApi;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.pokedexscreen.api.PokedexApi;
import com.example.rusili.homework11.pokedexscreen.model.Pokedex;
import com.example.rusili.homework11.util.Host;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rusi.li on 11/20/17.
 */

public class RetrofitFactory {
    private static RetrofitFactory retrofitFactory;

    private Retrofit retrofit;
    private PokedexListNetworkListener pokedexListNetworkListener = null;
    private PokedexNetworkListener pokedexNetworkListener = null;
    private PokemonNetworkListener pokemonNetworkListener = null;

    public static RetrofitFactory getInstance(){
        if (retrofitFactory == null){
            retrofitFactory = new RetrofitFactory();
        }
        return retrofitFactory;
    }

    public void setPokedexListener(PokedexNetworkListener pokedexNetworkListener){
        this.pokedexNetworkListener = pokedexNetworkListener;
    }

    public void setPokedexListNetworkListener(PokedexListNetworkListener pokedexListNetworkListener){
        this.pokedexListNetworkListener = pokedexListNetworkListener;
    }

    private Retrofit buildRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Host.PokeAPI.getUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public void getPokedexList() {
        PokedexApi pokedexService = buildRetrofit().create(PokedexApi.class);
        Call<List<Pokedex>> getServiceResponse = pokedexService.getListOfPokedexes();
        getServiceResponse.enqueue(new Callback<List<Pokedex>>() {
            @Override
            public void onResponse(@NonNull Call<List<Pokedex>> call, @NonNull Response<List<Pokedex>> response) {
                if (response.isSuccessful()) {
                    Log.d("onResponse: ", "Successful");

                    if (pokedexListNetworkListener != null) {
                        pokedexListNetworkListener.pokedexListCallback(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<Pokedex>> call, @NonNull Throwable t) {
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void getPokedex() {
        PokedexApi pokedexService = buildRetrofit().create(PokedexApi.class);
        Call<Pokedex> getServiceResponse = pokedexService.getPokedex();
        getServiceResponse.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(@NonNull Call<Pokedex> call, @NonNull Response<Pokedex> response) {
                if (response.isSuccessful()) {
                    Log.d("onResponse: ", "Successful");

                    if (pokedexNetworkListener != null) {
                        pokedexNetworkListener.pokedexCallback(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<Pokedex> call, @NonNull Throwable t) {
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public void getPokemon(String name) {
        PokemonApi pokedexService = buildRetrofit().create(PokemonApi.class);
        Call<Pokemon> getServiceResponse = pokedexService.getPokemon(name);
        getServiceResponse.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(@NonNull Call<Pokemon> call, @NonNull Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Log.d("onResponse: ", "Successful");

                    if (pokemonNetworkListener != null) {
                        pokemonNetworkListener.pokemonCallback(response.body());
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<Pokemon> call, @NonNull Throwable t) {
                Log.e("onFailure: ", t.getMessage());
            }
        });
    }

    public interface PokedexNetworkListener {
        void pokedexCallback(Pokedex pokedex);
    }

    public interface PokedexListNetworkListener {
        void pokedexListCallback(List<Pokedex> pokedex);
    }

    public interface PokemonNetworkListener{
        void pokemonCallback(Pokemon pokemon);
    }
}

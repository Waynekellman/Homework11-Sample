package com.example.rusili.homework11.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.rusili.homework11.common.AbstractRetrofitFactory;
import com.example.rusili.homework11.detailscreen.api.PokemonApi;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.pokedexscreen.api.PokedexApi;
import com.example.rusili.homework11.pokedexscreen.model.Pokedex;
import com.example.rusili.homework11.util.Host;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitFactory extends AbstractRetrofitFactory{
	private static RetrofitFactory retrofitFactory;

	private PokedexNetworkListener pokedexNetworkListener = null;
	private PokemonNetworkListener pokemonNetworkListener = null;

	public static RetrofitFactory getInstance () {
		if (retrofitFactory == null) {
			retrofitFactory = new RetrofitFactory();
		}
		return retrofitFactory;
	}
	private RetrofitFactory(){}

	public void setPokedexListener (PokedexNetworkListener pokedexNetworkListener) {
		this.pokedexNetworkListener = pokedexNetworkListener;
	}
	public void setPokemonNetworkListener (PokemonNetworkListener pokemonNetworkListener) {
		this.pokemonNetworkListener = pokemonNetworkListener;
	}

	public void getPokedex (int id) {
		PokedexApi pokedexService = buildRetrofit().create(PokedexApi.class);
		Call <Pokedex> getServiceResponse = pokedexService.getPokedex(id);
		getServiceResponse.enqueue(new Callback <Pokedex>() {
			@Override
			public void onResponse (@NonNull Call <Pokedex> call, @NonNull Response <Pokedex> response) {
				if (response.isSuccessful()) {
					Log.d("getPokedex onResponse: ", "Successful");

					if (pokedexNetworkListener != null) {
						pokedexNetworkListener.pokedexCallback(response.body());
					}
				}
			}
			@Override
			public void onFailure (@NonNull Call <Pokedex> call, @NonNull Throwable t) {
				Log.e("getPokedex onFailure: ", t.getMessage());
				pokedexNetworkListener.onErrorCallback(t);
			}
		});
	}

	public void getPokemon (String name) {
		PokemonApi pokedexService = buildRetrofit().create(PokemonApi.class);
		Call <Pokemon> getServiceResponse = pokedexService.getPokemon(name);
		getServiceResponse.enqueue(new Callback <Pokemon>() {
			@Override
			public void onResponse (@NonNull Call <Pokemon> call, @NonNull Response <Pokemon> response) {
				if (response.isSuccessful()) {
					Log.d("getPokemon onResponse: ", "Successful");

					if (pokemonNetworkListener != null) {
						pokemonNetworkListener.pokemonCallback(response.body());
					}
				}
			}
			@Override
			public void onFailure (@NonNull Call <Pokemon> call, @NonNull Throwable t) {
				Log.e("getPokemon onFailure: ", t.getMessage());
				pokemonNetworkListener.onErrorCallback(t);
			}
		});
	}

	@Override
	public String getHostUrl () {
		return Host.PokeAPI.getUrl();
	}

	public interface PokedexNetworkListener {
		void pokedexCallback (Pokedex pokedex);
		void onErrorCallback(Throwable t);
	}
	public interface PokemonNetworkListener {
		void pokemonCallback (Pokemon pokemon);
		void onErrorCallback(Throwable t);
	}
}
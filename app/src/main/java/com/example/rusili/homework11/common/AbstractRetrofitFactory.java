package com.example.rusili.homework11.common;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class AbstractRetrofitFactory {
	private Retrofit retrofit;

	public abstract String getHostUrl ();

	@NonNull
	protected Retrofit buildRetrofit (){
		if (retrofit == null) {
			retrofit = new Retrofit.Builder()
				  .baseUrl(getHostUrl())
				  .addConverterFactory(GsonConverterFactory.create())
				  .build();
		}
		return retrofit;
	}
}

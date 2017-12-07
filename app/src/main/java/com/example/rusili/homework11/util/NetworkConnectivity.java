package com.example.rusili.homework11.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

/**
 * Created by rusi.li on 11/30/17.
 */

//	Just a network connectivity check.
public class NetworkConnectivity {

	// Static method so I don't have to create an instance of this class everytime I want to call it.
	// I just copy and paste this code every time I need to check if the network is connected.
	public static boolean isConnected (@NonNull Context context) {
		ConnectivityManager connectivityManager =
			  (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
		return activeNetwork != null &&
			  activeNetwork.isConnectedOrConnecting();
	}
}

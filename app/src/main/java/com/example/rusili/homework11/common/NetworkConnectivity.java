package com.example.rusili.homework11.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;

/**
 * Created by rusi.li on 11/30/17.
 */

public class NetworkConnectivity {

    public static void checkWithIntent(@NonNull Activity activity, @Nullable Intent intent) {
        if (!check(activity)){
            Snackbar snackbar = Snackbar
                    .make(activity.findViewById(android.R.id.content), "No Network Connectivity", Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            if (intent != null) {
                activity.startActivity(intent);
            }
        }
    }

    private static boolean check(@NonNull Activity activity){
        ConnectivityManager cm =
                (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}

package com.example.rusili.homework11.util;

import android.support.annotation.NonNull;

public class TextHelper {

	@NonNull
	public static String capitalizeFirstLetter(@NonNull String word){
		return Character.toUpperCase(word.charAt(0)) + word.substring(1);	// Capitalizes the first letter of any String I give it.
	}
}

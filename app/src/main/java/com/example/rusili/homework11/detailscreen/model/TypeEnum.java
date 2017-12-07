package com.example.rusili.homework11.detailscreen.model;

import android.support.annotation.Nullable;

import com.example.rusili.homework11.R;

//	This will be new to you guys. I'm using an Enum here as I know there are only a certain amount of Types.
//	This will equate a type with its String equivalent, but more importantly, its corresponding color.
public enum TypeEnum {
	Normal("normal", R.color.normal),
	Fighting("fighting", R.color.fighting),
	Flying("flying", R.color.flying),
	Poison("poison", R.color.poison),
	Ground("ground", R.color.ground),
	Rock("rock", R.color.rock),
	Bug("bug", R.color.bug),
	Ghost("ghost", R.color.ghost),
	Steel("steel", R.color.steel),
	Fire("fire", R.color.fire),
	Water("water", R.color.water),
	Grass("grass", R.color.grass),
	Electric("electric", R.color.electric),
	Psychic("psychic", R.color.psychic),
	Ice("ice", R.color.ice),
	Dragon("dragon", R.color.dragon),
	Dark("dark", R.color.dark),
	Fairy("fairy", R.color.fairy);

	private final String name;
	private final int color;

	TypeEnum (final String name, final int color){
		this.name = name;
		this.color = color;
	}

	public static int getColorResource (@Nullable String input){
		for (TypeEnum typeEnum : TypeEnum.values()){
			if (typeEnum.name.equals(input)){
				return typeEnum.color;
			}
		}
		return 000000;
	}
}

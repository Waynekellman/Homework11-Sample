package com.example.rusili.homework11.detailscreen.model;

import com.example.rusili.homework11.R;

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

	public static int getColorResource (String input){
		for (TypeEnum typeEnum : TypeEnum.values()){
			if (typeEnum.name.equals(input)){
				int temp = typeEnum.color;
				return typeEnum.color;
			}
		}
		return 000000;
	}
}

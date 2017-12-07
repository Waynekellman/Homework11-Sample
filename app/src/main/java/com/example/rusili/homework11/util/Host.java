package com.example.rusili.homework11.util;

/**
 * Created by rusi.li on 11/22/17.
 */

//  This enum allows me to reference this Url without going into the Resources(which require context)
//  The final field, Non-public constructor, and getUrl method are all required to return the Url "value" from the PokeApi "key"
public enum Host {
    PokeAPI("https://pokeapi.co/api/v2/");

    private final String url;

    Host (final String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }
}
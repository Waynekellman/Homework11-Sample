package com.example.rusili.homework11.pokedexActivity.model;

import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.example.rusili.homework11.pokedexActivity.model.objects.Region;
import com.example.rusili.homework11.pokedexActivity.model.objects.VersionGroups;

/**
 * Created by rusi.li on 11/22/17.
 */

public class Pokedex {
    private int id;
    private Region region;
    private VersionGroups[] version_groups;
    private PokemonEntries[] pokemon_entries;

    public int getId() {
        return id;
    }

    public Region getRegion() {
        return region;
    }

    public VersionGroups[] getVersionGroups() {
        return version_groups;
    }

    public PokemonEntries[] getPokemonEntries() {
        return pokemon_entries;
    }
}

package com.example.rusili.homework11.pokedexscreen.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rusili.homework11.R;

public class PokedexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPokedexListFragment();
    }

    private void setupPokedexListFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace()
                .commit();
    }

    private void showPokedexFragment(){
        // Show Pokedex fragment
    }

}

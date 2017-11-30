package com.example.rusili.homework11.splashscreen;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractSplashActivity;
import com.example.rusili.homework11.pokedexscreen.view.PokedexGeneralActivity;

/**
 * Created by rusi.li on 11/29/17.
 */

public class SplashActivity extends AbstractSplashActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.splash_screen_layout;
    }

    @Override
    protected Class<?> getNextActivity() {
        return PokedexGeneralActivity.class;
    }
}
package com.example.rusili.homework11.splashscreen;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.common.AbstractSplashActivity;
import com.example.rusili.homework11.pokedexscreen.view.PokedexGeneralActivity;

/**
 * Created by rusi.li on 11/29/17.
 */

public class SplashActivity extends AbstractSplashActivity {

    @Override
    protected void setAnimation () {
        ImageView icon = findViewById(R.id.splash_icon);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in_splash);
        icon.setAnimation(fadeIn);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.splash_screen_layout;
    }

    @Override
    protected Class<?> getNextActivity() {
        return PokedexGeneralActivity.class;
    }
}
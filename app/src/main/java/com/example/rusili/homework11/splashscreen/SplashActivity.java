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

//  Extends the Abstract Splash Activity so I don't have to see/write a lot of code.
public class SplashActivity extends AbstractSplashActivity {

    @Override
    protected void setAnimation () {
        ImageView icon = findViewById(R.id.splash_icon);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in_splash);
        icon.setAnimation(fadeIn);      //  Sets the animation for the imageview I want. View animations don't require a lot of code.
    }

    @Override
    protected int getLayoutId() {
        return R.layout.splash_screen_layout;       //  Tells the abstract class which layout I want inflated for this Activity.
    }

    @Override
    protected Class<?> getNextActivity() {
        return PokedexGeneralActivity.class;        //  This method returns to the Abstract class which Activity I want to navigate to. As you can see, there's no need to create an Intent here because I already did it in the Abstract class.
    }
}
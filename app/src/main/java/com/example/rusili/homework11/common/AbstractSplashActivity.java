package com.example.rusili.homework11.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rusili.homework11.R;

/**
 * Created by rusi.li on 11/29/17.
 */

//  An Abstract Splash screen Activity to remove a lot of boilerplate code that we know all splash screens need:
//  Ex: onClick, Intents, etc
public abstract class AbstractSplashActivity extends AppCompatActivity {
    private View container;     // No need to get reference to this container, so I don't need a getter.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        setContainer();
    }

    private void setContainer () {      //  I make the whole layout clickable. It also MUST contain an id called "container", or else it crashes.
        container = findViewById(R.id.container);   // This assumes my layout has a layout with the id of container. A bit scary.
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toNextActivity();
            }
        });
    }

    @Override
    protected void onResume () {
        super.onResume();
        setAnimation();
    }

    private void toNextActivity() {     //  Removes the intent boilerplate and leaves the only variable to the getNextActivity method. I don't want my extended classes to call this, so I make it private
        Intent toNextActivity = new Intent(AbstractSplashActivity.this, getNextActivity());
        startActivity(toNextActivity);
    }

    protected abstract void setAnimation ();
    protected abstract int getLayoutId();
    protected abstract Class<?> getNextActivity();
}

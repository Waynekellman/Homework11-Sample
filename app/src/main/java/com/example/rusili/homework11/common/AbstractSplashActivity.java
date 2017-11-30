package com.example.rusili.homework11.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rusili.homework11.R;

/**
 * Created by rusi.li on 11/29/17.
 */

public abstract class AbstractSplashActivity extends AppCompatActivity {
    private View container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        container = findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toNextActivity();
            }
        });
    }

    private void toNextActivity() {
        Intent toNextActivity = new Intent(AbstractSplashActivity.this, getNextActivity());
        startActivity(toNextActivity);
    }

    protected abstract int getLayoutId();
    protected abstract Class<?> getNextActivity();

    public void setLayoutEnterTransition(){}
    public void setLayoutExitTransition(){}
}

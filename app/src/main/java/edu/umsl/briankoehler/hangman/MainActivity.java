package edu.umsl.briankoehler.hangman;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FragmentManager manager = getSupportFragmentManager();
        TitleScreenFragment mTitleScreenFragment = (TitleScreenFragment) manager.findFragmentById(R.id.fragment_container);

        if (mTitleScreenFragment == null) {
            mTitleScreenFragment = new TitleScreenFragment();
            manager.beginTransaction()
                    .add(R.id.fragment_container, mTitleScreenFragment)
                    .commit();
        }
    }
}

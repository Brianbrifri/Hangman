package edu.umsl.briankoehler.hangman;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity implements TitleScreenFragment.listener, LibraryBuilderFragment.listener{

    LibraryBuilderFragment mLibraryBuilderFragment;
    TitleScreenFragment mTitleScreenFragment;
    private static final String SECONDARY_TAG = "SECONDARY_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FragmentManager manager = getSupportFragmentManager();

        mTitleScreenFragment = (TitleScreenFragment) manager.findFragmentById(R.id.fragment_container);
        if (mTitleScreenFragment == null) {
            mTitleScreenFragment = new TitleScreenFragment();
            manager.beginTransaction()
                    .add(R.id.fragment_container, mTitleScreenFragment)
                    .commit();
        }

        mLibraryBuilderFragment = (LibraryBuilderFragment) manager.findFragmentByTag(SECONDARY_TAG);
        if(mLibraryBuilderFragment == null) {
            mLibraryBuilderFragment = new LibraryBuilderFragment();
            manager.beginTransaction()
                    .add(mLibraryBuilderFragment, SECONDARY_TAG)
                    .commit();
        }

        mTitleScreenFragment.setListener(this);
        mLibraryBuilderFragment.setListener(this);
        SugarContext.init(this);

    }


    @Override
    public void onDictionaryButtonPress() {
        mLibraryBuilderFragment.addWordsFromFileToDb();
    }

    @Override
    public void onUpdateComplete() {
        mTitleScreenFragment.reenableChoices();
    }

    @Override
    public void updateProgressBar(int progress) {
        mTitleScreenFragment.updateProgressBar(progress);
    }

    public void onDictionaryButtonPress(View view) {
    }
}

package edu.umsl.briankoehler.hangman;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity implements TitleScreenFragment.listener, LibraryBuilderFragment.listener{

    //Member variables for the fragments used in this activity
    LibraryBuilderFragment mLibraryBuilderFragment;
    TitleScreenFragment mTitleScreenFragment;
    private static final String SECONDARY_TAG = "SECONDARY_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FragmentManager manager = getSupportFragmentManager();

        //Attaching the view fragment by id
        mTitleScreenFragment = (TitleScreenFragment) manager.findFragmentById(R.id.fragment_container);
        if (mTitleScreenFragment == null) {
            mTitleScreenFragment = new TitleScreenFragment();
            manager.beginTransaction()
                    .add(R.id.fragment_container, mTitleScreenFragment)
                    .commit();
        }

        //Attaching the headless fragment by tag
        mLibraryBuilderFragment = (LibraryBuilderFragment) manager.findFragmentByTag(SECONDARY_TAG);
        if(mLibraryBuilderFragment == null) {
            mLibraryBuilderFragment = new LibraryBuilderFragment();
            manager.beginTransaction()
                    .add(mLibraryBuilderFragment, SECONDARY_TAG)
                    .commit();
        }

        //Setting listeners that both fragments use
        mTitleScreenFragment.setListener(this);
        mLibraryBuilderFragment.setListener(this);
        //Initializing Sugar ORM for database management
        SugarContext.init(this);

    }


    //Implementing listener interface to call addWordsFromFileToDb() in the LibraryBuilderFragment
    //from the TitleScreenFragment
    @Override
    public void onDictionaryButtonPress() {
        mLibraryBuilderFragment.addWordsFromFileToDb();
    }

    //The library fragment calls this listener to tell the Title fragment that the
    //import of the words from the text file is done
    @Override
    public void onUpdateComplete() {
        mTitleScreenFragment.reenableChoices();
    }

    //The library fragment calls this function to tell the title fragment
    //what the progress is for the progress bar
    @Override
    public void updateProgressBar(int progress) {
        mTitleScreenFragment.updateProgressBar(progress);
    }

}

package edu.umsl.briankoehler.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


public class TitleScreenFragment extends Fragment{
    private Button mEasyButton;
    private Button mMediumButton;
    private Button mHardButton;
    private Button mDictionaryButton;
    private listener mListener;
    private ProgressBar mProgressBar;
    private static final int EASY = 0;
    private static final int MEDIUM = 1;
    private static final int HARD = 2;


    //Interface that this fragement uses
    interface listener {
        void onDictionaryButtonPress();
    }

    //Listener setter function
    public void setListener(listener listener) {
        mListener = listener;
    }

    //Wire up buttons and inflate view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_title_layout, container, false);
        mEasyButton = (Button) view.findViewById(R.id.easy_button);
        mEasyButton.setOnClickListener(onEasyButtonPress());
        mMediumButton = (Button) view.findViewById(R.id.medium_button);
        mMediumButton.setOnClickListener(onMediumButtonPress());
        mHardButton = (Button) view.findViewById(R.id.hard_button);
        mHardButton.setOnClickListener(onHardButtonPress());
        mDictionaryButton = (Button) view.findViewById(R.id.load_dictionary);
        mDictionaryButton.setOnClickListener(onDictionaryButtonPress());

        //This checks to see if the words have been added to the database.
        //If yes, the load dictionary button is disabled. If no, the
        //game mode buttons are disabled instead
        GameWord mGameWord = GameWord.findById(GameWord.class, 4);

        if (mGameWord != null) {
            mDictionaryButton.setEnabled(false);
        }

        else {
            mDictionaryButton.setEnabled(true);
            mEasyButton.setEnabled(false);
            mMediumButton.setEnabled(false);
            mHardButton.setEnabled(false);
        }

        //Wire up progress bar
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mProgressBar.setMax(100);
        mProgressBar.setProgress(0);
        return view;
    }

    //On click listener fo load dictionary button. Calls listener
    private View.OnClickListener onDictionaryButtonPress() {
        mDictionaryButton.setEnabled(false);
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDictionaryButtonPress();
            }
        };
    }

    //Easy button press. Starts GameActivity and passes the EASY parameter
    private View.OnClickListener onEasyButtonPress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.newIntent(getActivity(), EASY);
                startActivity(intent);
            }
        };
    }

    //Medium button press. Starts GameActivity and passes the MEDIUM parameter
    private View.OnClickListener onMediumButtonPress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.newIntent(getActivity(), MEDIUM);
                startActivity(intent);
            }
        };
    }

    //Hard button press. Starts GameActivity and passes the HARD parameter
    private View.OnClickListener onHardButtonPress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.newIntent(getActivity(), HARD);
                startActivity(intent);
            }
        };
    }

    //This gets called when the words are done being loaded into disk
    public void reenableChoices() {
        mDictionaryButton.setEnabled(false);
        mEasyButton.setEnabled(true);
        mMediumButton.setEnabled(true);
        mHardButton.setEnabled(true);
    }

    //This gets called by activity via listener from controller fragment
    //and updates progress bar
    public void updateProgressBar(int progress) {
        mProgressBar.setProgress(progress);
    }
}

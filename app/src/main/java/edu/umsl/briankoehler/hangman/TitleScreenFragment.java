package edu.umsl.briankoehler.hangman;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;


public class TitleScreenFragment extends Fragment{
    private Button mEasyButton;
    private Button mMediumButton;
    private Button mHardButton;
    private Button mDictionaryButton;
    private listener mListener;
    private ProgressBar mProgressBar;
    private GameWord mGameWord;


    interface listener {
        void onDictionaryButtonPress();
    }

    public void setListener(listener listener) {
        mListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_title_layout, container, false);
        mEasyButton = (Button) view.findViewById(R.id.easy_button);
        mMediumButton = (Button) view.findViewById(R.id.medium_button);
        mHardButton = (Button) view.findViewById(R.id.hard_button);
        mDictionaryButton = (Button) view.findViewById(R.id.load_dictionary);
        mDictionaryButton.setOnClickListener(onDictionaryButtonPress());
        mGameWord = new GameWord();
        mGameWord = GameWord.findById(GameWord.class, 4);

        if (mGameWord != null) {
            mDictionaryButton.setEnabled(false);
        }

        else {
            mDictionaryButton.setEnabled(true);
            mEasyButton.setEnabled(false);
            mMediumButton.setEnabled(false);
            mHardButton.setEnabled(false);
        }

        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mProgressBar.setMax(100);
        mProgressBar.setProgress(0);
        return view;
    }

    private View.OnClickListener onDictionaryButtonPress() {
        mDictionaryButton.setEnabled(false);
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDictionaryButtonPress();
            }
        };
    }

    public void reenableChoices() {
        mDictionaryButton.setEnabled(false);
        mEasyButton.setEnabled(true);
        mMediumButton.setEnabled(true);
        mHardButton.setEnabled(true);
    }

    public void updateProgressBar(int progress) {
        mProgressBar.setProgress(progress);
    }
}

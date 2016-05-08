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
        mEasyButton.setOnClickListener(onEasyButtonPress());
        mMediumButton = (Button) view.findViewById(R.id.medium_button);
        mMediumButton.setOnClickListener(onMediumButtonPress());
        mHardButton = (Button) view.findViewById(R.id.hard_button);
        mHardButton.setOnClickListener(onHardButtonPress());
        mDictionaryButton = (Button) view.findViewById(R.id.load_dictionary);
        mDictionaryButton.setOnClickListener(onDictionaryButtonPress());
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

    private View.OnClickListener onEasyButtonPress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.newIntent(getActivity(), EASY);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onMediumButtonPress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.newIntent(getActivity(), MEDIUM);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onHardButtonPress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.newIntent(getActivity(), HARD);
                startActivity(intent);
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

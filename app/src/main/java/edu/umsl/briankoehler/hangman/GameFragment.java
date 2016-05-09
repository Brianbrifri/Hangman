package edu.umsl.briankoehler.hangman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Brian Koehler on 5/4/2016.
 */
public class GameFragment extends Fragment{

    private TextView mWordTextView;
    private GameFragmentListener mListener;

    private Button mQButton;
    private Button mWButton;
    private Button mEButton;
    private Button mRButton;
    private Button mTButton;
    private Button mYButton;
    private Button mUButton;
    private Button mIButton;
    private Button mOButton;
    private Button mPButton;
    private Button mAButton;
    private Button mSButton;
    private Button mDButton;
    private Button mFButton;
    private Button mGButton;
    private Button mHButton;
    private Button mJButton;
    private Button mKButton;
    private Button mLButton;
    private Button mZButton;
    private Button mXButton;
    private Button mCButton;
    private Button mVButton;
    private Button mBButton;
    private Button mNButton;
    private Button mMButton;


    interface GameFragmentListener {
        String updateTextView();
        String validateLetterGuess(char c);
    }

    public void setListener (GameFragmentListener listener) {
        mListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_layout, container, false);
        mQButton = (Button) view.findViewById(R.id.imageButtonQ);
        mQButton.setOnClickListener(letterGuess());
        mWButton = (Button) view.findViewById(R.id.imageButtonW);
        mWButton.setOnClickListener(letterGuess());
        mEButton = (Button) view.findViewById(R.id.imageButtonE);
        mEButton.setOnClickListener(letterGuess());
        mRButton = (Button) view.findViewById(R.id.imageButtonR);
        mRButton.setOnClickListener(letterGuess());
        mTButton = (Button) view.findViewById(R.id.imageButtonT);
        mTButton.setOnClickListener(letterGuess());
        mYButton = (Button) view.findViewById(R.id.imageButtonY);
        mYButton.setOnClickListener(letterGuess());
        mUButton = (Button) view.findViewById(R.id.imageButtonU);
        mUButton.setOnClickListener(letterGuess());
        mIButton = (Button) view.findViewById(R.id.imageButtonI);
        mIButton.setOnClickListener(letterGuess());
        mOButton = (Button) view.findViewById(R.id.imageButtonO);
        mOButton.setOnClickListener(letterGuess());
        mPButton = (Button) view.findViewById(R.id.imageButtonP);
        mPButton.setOnClickListener(letterGuess());
        mAButton = (Button) view.findViewById(R.id.imageButtonA);
        mAButton.setOnClickListener(letterGuess());
        mSButton = (Button) view.findViewById(R.id.imageButtonS);
        mSButton.setOnClickListener(letterGuess());
        mDButton = (Button) view.findViewById(R.id.imageButtonD);
        mDButton.setOnClickListener(letterGuess());
        mFButton = (Button) view.findViewById(R.id.imageButtonF);
        mFButton.setOnClickListener(letterGuess());
        mGButton = (Button) view.findViewById(R.id.imageButtonG);
        mGButton.setOnClickListener(letterGuess());
        mHButton = (Button) view.findViewById(R.id.imageButtonH);
        mHButton.setOnClickListener(letterGuess());
        mJButton = (Button) view.findViewById(R.id.imageButtonJ);
        mJButton.setOnClickListener(letterGuess());
        mKButton = (Button) view.findViewById(R.id.imageButtonK);
        mKButton.setOnClickListener(letterGuess());
        mLButton = (Button) view.findViewById(R.id.imageButtonL);
        mLButton.setOnClickListener(letterGuess());
        mZButton = (Button) view.findViewById(R.id.imageButtonZ);
        mZButton.setOnClickListener(letterGuess());
        mXButton = (Button) view.findViewById(R.id.imageButtonX);
        mXButton.setOnClickListener(letterGuess());
        mCButton = (Button) view.findViewById(R.id.imageButtonC);
        mCButton.setOnClickListener(letterGuess());
        mVButton = (Button) view.findViewById(R.id.imageButtonV);
        mVButton.setOnClickListener(letterGuess());
        mBButton = (Button) view.findViewById(R.id.imageButtonB);
        mBButton.setOnClickListener(letterGuess());
        mNButton = (Button) view.findViewById(R.id.imageButtonN);
        mNButton.setOnClickListener(letterGuess());
        mMButton = (Button) view.findViewById(R.id.imageButtonM);
        mMButton.setOnClickListener(letterGuess());
        mWordTextView = (TextView) view.findViewById(R.id.main_text_view);

        updateTextView();

        return view;
    }

    public void updateTextView() {
        mWordTextView.setText(mListener.updateTextView());
    }

    private View.OnClickListener letterGuess() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imageButtonA:
                        mWordTextView.setText(mListener.validateLetterGuess('a'));
                        mAButton.setEnabled(false);
                        mAButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonB:
                        mWordTextView.setText(mListener.validateLetterGuess('b'));
                        mBButton.setEnabled(false);
                        mBButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonC:
                        mWordTextView.setText(mListener.validateLetterGuess('c'));
                        mCButton.setEnabled(false);
                        mCButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonD:
                        mWordTextView.setText(mListener.validateLetterGuess('d'));
                        mDButton.setEnabled(false);
                        mDButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonE:
                        mWordTextView.setText(mListener.validateLetterGuess('e'));
                        mEButton.setEnabled(false);
                        mEButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonF:
                        mWordTextView.setText(mListener.validateLetterGuess('f'));
                        mFButton.setEnabled(false);
                        mFButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonG:
                        mWordTextView.setText(mListener.validateLetterGuess('g'));
                        mGButton.setEnabled(false);
                        mGButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonH:
                        mWordTextView.setText(mListener.validateLetterGuess('h'));
                        mHButton.setEnabled(false);
                        mHButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonI:
                        mWordTextView.setText(mListener.validateLetterGuess('i'));
                        mIButton.setEnabled(false);
                        mIButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonJ:
                        mWordTextView.setText(mListener.validateLetterGuess('j'));
                        mJButton.setEnabled(false);
                        mJButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonK:
                        mWordTextView.setText(mListener.validateLetterGuess('k'));
                        mKButton.setEnabled(false);
                        mKButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonL:
                        mWordTextView.setText(mListener.validateLetterGuess('l'));
                        mLButton.setEnabled(false);
                        mLButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonM:
                        mWordTextView.setText(mListener.validateLetterGuess('m'));
                        mMButton.setEnabled(false);
                        mMButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonN:
                        mWordTextView.setText(mListener.validateLetterGuess('n'));
                        mNButton.setEnabled(false);
                        mNButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonO:
                        mWordTextView.setText(mListener.validateLetterGuess('o'));
                        mOButton.setEnabled(false);
                        mOButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonP:
                        mWordTextView.setText(mListener.validateLetterGuess('p'));
                        mPButton.setEnabled(false);
                        mPButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonQ:
                        mWordTextView.setText(mListener.validateLetterGuess('q'));
                        mQButton.setEnabled(false);
                        mQButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonR:
                        mWordTextView.setText(mListener.validateLetterGuess('r'));
                        mRButton.setEnabled(false);
                        mRButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonS:
                        mWordTextView.setText(mListener.validateLetterGuess('s'));
                        mSButton.setEnabled(false);
                        mSButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonT:
                        mWordTextView.setText(mListener.validateLetterGuess('t'));
                        mTButton.setEnabled(false);
                        mTButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonU:
                        mWordTextView.setText(mListener.validateLetterGuess('u'));
                        mUButton.setEnabled(false);
                        mUButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonV:
                        mWordTextView.setText(mListener.validateLetterGuess('v'));
                        mVButton.setEnabled(false);
                        mVButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonW:
                        mWordTextView.setText(mListener.validateLetterGuess('w'));
                        mWButton.setEnabled(false);
                        mWButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonX:
                        mWordTextView.setText(mListener.validateLetterGuess('x'));
                        mXButton.setEnabled(false);
                        mXButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonY:
                        mWordTextView.setText(mListener.validateLetterGuess('y'));
                        mYButton.setEnabled(false);
                        mYButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    case R.id.imageButtonZ:
                        mWordTextView.setText(mListener.validateLetterGuess('z'));
                        mZButton.setEnabled(false);
                        mZButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        break;
                    default:
                        break;
                }
            }
        };
    }
}

package edu.umsl.briankoehler.hangman;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Brian Koehler on 5/4/2016.
 */
public class GameFragment extends Fragment{

    private TextView mWordTextView;
    private GameFragmentListener mListener;
    private Drawable mDrawable;
    private Drawable mHangmanDrawable;
    private ArrayList<Drawable> sequenceOfDrawables;
    private Drawable sequence_0;
    private Drawable sequence_1;
    private Drawable sequence_2;
    private Drawable sequence_3;
    private Drawable sequence_4;
    private Drawable sequence_5;
    private Drawable sequence_6;
    private Drawable sequence_7;
    private Drawable sequence_8;
    private Drawable sequence_9;
    private Drawable sequence_10;
    private Drawable sequence_11;
    private Drawable sequence_12;
    private ImageView hangmanView;

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
        mDrawable = mQButton.getBackground();
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

        hangmanView = (ImageView) view.findViewById(R.id.hangman_view);

        sequenceOfDrawables = new ArrayList<>();

        sequence_0 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_0);
        sequenceOfDrawables.add(sequence_0);
        sequence_1 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_1);
        sequenceOfDrawables.add(sequence_1);
        sequence_2 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_2);
        sequenceOfDrawables.add(sequence_2);
        sequence_3 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_3);
        sequenceOfDrawables.add(sequence_3);
        sequence_4 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_4);
        sequenceOfDrawables.add(sequence_4);
        sequence_5 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_5);
        sequenceOfDrawables.add(sequence_5);
        sequence_6 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_6);
        sequenceOfDrawables.add(sequence_6);
        sequence_7 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_7);
        sequenceOfDrawables.add(sequence_7);
        sequence_8 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_8);
        sequenceOfDrawables.add(sequence_8);
        sequence_9 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_9);
        sequenceOfDrawables.add(sequence_9);
        sequence_10 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_10);
        sequenceOfDrawables.add(sequence_10);
        sequence_11 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_11);
        sequenceOfDrawables.add(sequence_11);
        sequence_12 = ContextCompat.getDrawable(getContext(), R.drawable.sequence_12);
        sequenceOfDrawables.add(sequence_12);

        hangmanView.setBackground(sequenceOfDrawables.get(0));

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
                        mAButton.setEnabled(false);
                        mAButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('a'));
                        break;
                    case R.id.imageButtonB:
                        mBButton.setEnabled(false);
                        mBButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('b'));
                        break;
                    case R.id.imageButtonC:
                        mCButton.setEnabled(false);
                        mCButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('c'));
                        break;
                    case R.id.imageButtonD:
                        mDButton.setEnabled(false);
                        mDButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('d'));
                        break;
                    case R.id.imageButtonE:
                        mEButton.setEnabled(false);
                        mEButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('e'));
                        break;
                    case R.id.imageButtonF:
                        mFButton.setEnabled(false);
                        mFButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('f'));
                        break;
                    case R.id.imageButtonG:
                        mGButton.setEnabled(false);
                        mGButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('g'));
                        break;
                    case R.id.imageButtonH:
                        mHButton.setEnabled(false);
                        mHButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('h'));
                        break;
                    case R.id.imageButtonI:
                        mIButton.setEnabled(false);
                        mIButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('i'));
                        break;
                    case R.id.imageButtonJ:
                        mJButton.setEnabled(false);
                        mJButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('j'));
                        break;
                    case R.id.imageButtonK:
                        mKButton.setEnabled(false);
                        mKButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('k'));
                        break;
                    case R.id.imageButtonL:
                        mLButton.setEnabled(false);
                        mLButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('l'));
                        break;
                    case R.id.imageButtonM:
                        mMButton.setEnabled(false);
                        mMButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('m'));
                        break;
                    case R.id.imageButtonN:
                        mNButton.setEnabled(false);
                        mNButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('n'));
                        break;
                    case R.id.imageButtonO:
                        mOButton.setEnabled(false);
                        mOButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('o'));
                        break;
                    case R.id.imageButtonP:
                        mPButton.setEnabled(false);
                        mPButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('p'));
                        break;
                    case R.id.imageButtonQ:
                        mQButton.setEnabled(false);
                        mQButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('q'));
                        break;
                    case R.id.imageButtonR:
                        mRButton.setEnabled(false);
                        mRButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('r'));
                        break;
                    case R.id.imageButtonS:
                        mSButton.setEnabled(false);
                        mSButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('s'));
                        break;
                    case R.id.imageButtonT:
                        mTButton.setEnabled(false);
                        mTButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('t'));
                        break;
                    case R.id.imageButtonU:
                        mUButton.setEnabled(false);
                        mUButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('u'));
                        break;
                    case R.id.imageButtonV:
                        mVButton.setEnabled(false);
                        mVButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('v'));
                        break;
                    case R.id.imageButtonW:
                        mWButton.setEnabled(false);
                        mWButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('w'));
                        break;
                    case R.id.imageButtonX:
                        mXButton.setEnabled(false);
                        mXButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('x'));
                        break;
                    case R.id.imageButtonY:
                        mYButton.setEnabled(false);
                        mYButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('y'));
                        break;
                    case R.id.imageButtonZ:
                        mZButton.setEnabled(false);
                        mZButton.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.guessedLetter));
                        mWordTextView.setText(mListener.validateLetterGuess('z'));
                        break;
                    default:
                        break;
                }
            }
        };
    }

    public void setEndGameState() {
        mAButton.setEnabled(false);
        mAButton.setBackground(mDrawable);
        mBButton.setEnabled(false);
        mBButton.setBackground(mDrawable);
        mCButton.setEnabled(false);
        mCButton.setBackground(mDrawable);
        mDButton.setEnabled(false);
        mDButton.setBackground(mDrawable);
        mEButton.setEnabled(false);
        mEButton.setBackground(mDrawable);
        mFButton.setEnabled(false);
        mFButton.setBackground(mDrawable);
        mGButton.setEnabled(false);
        mGButton.setBackground(mDrawable);
        mHButton.setEnabled(false);
        mHButton.setBackground(mDrawable);
        mIButton.setEnabled(false);
        mIButton.setBackground(mDrawable);
        mJButton.setEnabled(false);
        mJButton.setBackground(mDrawable);
        mKButton.setEnabled(false);
        mKButton.setBackground(mDrawable);
        mLButton.setEnabled(false);
        mLButton.setBackground(mDrawable);
        mMButton.setEnabled(false);
        mMButton.setBackground(mDrawable);
        mNButton.setEnabled(false);
        mNButton.setBackground(mDrawable);
        mOButton.setEnabled(false);
        mOButton.setBackground(mDrawable);
        mPButton.setEnabled(false);
        mPButton.setBackground(mDrawable);
        mQButton.setEnabled(false);
        mQButton.setBackground(mDrawable);
        mRButton.setEnabled(false);
        mRButton.setBackground(mDrawable);
        mSButton.setEnabled(false);
        mSButton.setBackground(mDrawable);
        mTButton.setEnabled(false);
        mTButton.setBackground(mDrawable);
        mUButton.setEnabled(false);
        mUButton.setBackground(mDrawable);
        mVButton.setEnabled(false);
        mVButton.setBackground(mDrawable);
        mWButton.setEnabled(false);
        mWButton.setBackground(mDrawable);
        mXButton.setEnabled(false);
        mXButton.setBackground(mDrawable);
        mYButton.setEnabled(false);
        mYButton.setBackground(mDrawable);
        mZButton.setEnabled(false);
        mZButton.setBackground(mDrawable);
    }

    public void resetGame() {
        mAButton.setEnabled(true);
        mBButton.setEnabled(true);
        mCButton.setEnabled(true);
        mDButton.setEnabled(true);
        mEButton.setEnabled(true);
        mFButton.setEnabled(true);
        mGButton.setEnabled(true);
        mHButton.setEnabled(true);
        mIButton.setEnabled(true);
        mJButton.setEnabled(true);
        mKButton.setEnabled(true);
        mLButton.setEnabled(true);
        mMButton.setEnabled(true);
        mNButton.setEnabled(true);
        mOButton.setEnabled(true);
        mPButton.setEnabled(true);
        mQButton.setEnabled(true);
        mRButton.setEnabled(true);
        mSButton.setEnabled(true);
        mTButton.setEnabled(true);
        mUButton.setEnabled(true);
        mVButton.setEnabled(true);
        mWButton.setEnabled(true);
        mXButton.setEnabled(true);
        mYButton.setEnabled(true);
        mZButton.setEnabled(true);
        hangmanView.setBackground(sequenceOfDrawables.get(0));
        updateTextView();
    }

    public void updateHangmanDrawable(int sequence) {
        hangmanView.setBackground(sequenceOfDrawables.get(sequence));
    }
}

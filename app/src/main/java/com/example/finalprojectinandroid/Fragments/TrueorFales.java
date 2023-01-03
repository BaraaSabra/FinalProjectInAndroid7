package com.example.finalprojectinandroid.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectinandroid.R;
import com.example.finalprojectinandroid.databinding.FragmentTrueorFalesBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrueorFales#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrueorFales extends Fragment {
    FragmentTrueorFalesBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_QUESTION = "Question";
    private static final String ARG_TRUEANSWER = "trueAnswer";
    private static final String ARG_HINT = "Hint";
    private static final String ARG_TIMER= "Timer";
    OnAnswer answer;



    // TODO: Rename and change types of parameters
    private String Question;
    private String TrueAnswer;
    private String hint;
    private int timer;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        answer=(OnAnswer) getContext();
    }

    public TrueorFales() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TrueorFales newInstance(String Question, String TrueAnswer,String hint,int time) {
        TrueorFales fragment = new TrueorFales();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, Question);
        args.putString(ARG_TRUEANSWER, TrueAnswer);
        args.putString(ARG_HINT, hint);
        args.putInt(ARG_TIMER,time);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Question = getArguments().getString(ARG_QUESTION);
            TrueAnswer = getArguments().getString(ARG_TRUEANSWER);
            hint = getArguments().getString(ARG_HINT);
            timer = getArguments().getInt(ARG_TIMER);
        }
        Timer();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding = FragmentTrueorFalesBinding.inflate(getLayoutInflater());
        binding.Question.setText(Question);

        binding.btnChick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.redTrue.isChecked()){
                    answer.ChecktheAnswer(TrueAnswer,binding.redTrue.getText().toString(),1,hint);

                } else if (binding.rabFules.isChecked()) {
                    answer.ChecktheAnswer(TrueAnswer,binding.rabFules.getText().toString(),1,hint);
                }

            }
        });


        return binding.getRoot();



    }

    private void Timer() {

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                binding.timer.setText(String.valueOf(timer));
                timer--;
            }

            public void onFinish() {
                binding.timer.setText("FINISH!!");
            }
        }.start();
    }


}
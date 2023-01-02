package com.example.finalprojectinandroid.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.finalprojectinandroid.R;
import com.example.finalprojectinandroid.databinding.FragmentChooseBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_QUESTION = "Question";
    private static final String ARG_ANSWER1 = "answer1";
    private static final String ARG_ANSWER2 = "answer2";
    private static final String ARG_ANSWER3 = "answer3";
    private static final String ARG_ANSWER4 = "answer4";
    private static final String ARG_TREUEANSWER = "trueAnswer";
    OnAnswer answer;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        answer=(OnAnswer) getContext();
    }

    // TODO: Rename and change types of parameters
    private String Question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String trueAnswer;

    public ChooseFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ChooseFragment newInstance(String Question, String Answer1, String Answer2, String Answer3, String Answer4, String TrueAnswer) {
        ChooseFragment fragment = new ChooseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, Question);
        args.putString(ARG_ANSWER1, Answer1);
        args.putString(ARG_ANSWER2, Answer2);
        args.putString(ARG_ANSWER3, Answer3);
        args.putString(ARG_ANSWER4, Answer4);
        args.putString(ARG_TREUEANSWER, TrueAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Question = getArguments().getString(ARG_QUESTION);
            answer1 = getArguments().getString(ARG_ANSWER1);
            answer2 = getArguments().getString(ARG_ANSWER2);
            answer3 = getArguments().getString(ARG_ANSWER3);
            answer4 = getArguments().getString(ARG_ANSWER4);
            trueAnswer = getArguments().getString(ARG_TREUEANSWER);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChooseBinding binding = FragmentChooseBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        binding.Question.setText(Question);
        binding.red1Answer1.setText(answer1);
        binding.rabAnswer2.setText(answer2);
        binding.answer3.setText(answer3);
        binding.answer4.setText(answer4);



        binding.btnChick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.red1Answer1.isChecked()) {
                    answer.ChecktheAnswer(trueAnswer,binding.red1Answer1.getText().toString(),2);


                } else if (binding.rabAnswer2.isChecked()) {
                    answer.ChecktheAnswer(trueAnswer,binding.rabAnswer2.getText().toString(),2);

                } else if (binding.answer3.isChecked()) {
                    answer.ChecktheAnswer(trueAnswer,binding.answer3.getText().toString(),2);

                } else if (binding.answer4.isChecked()) {
                    answer.ChecktheAnswer(trueAnswer, binding.answer4.getText().toString(), 2);
                }

            }
        });


        return binding.getRoot();

    }
}
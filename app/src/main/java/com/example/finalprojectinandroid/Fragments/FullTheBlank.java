package com.example.finalprojectinandroid.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectinandroid.databinding.FragmentFullTheBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FullTheBlank#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FullTheBlank extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_QUESTION = "Question";
    private static final String ARG_TRUEANSWER = "trueAnswer";
    private static final String ARG_HINT = "HINT";

    OnAnswer answer;

    // TODO: Rename and change types of parameters
    private String Question;
    private String TrueAnswer;

    private String hint;

    public FullTheBlank() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        answer = (OnAnswer) getContext();
    }

    // TODO: Rename and change types and number of parameters
    public static FullTheBlank newInstance(String Question, String TrueAnswer,String hint) {
        FullTheBlank fragment = new FullTheBlank();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, Question);
        args.putString(ARG_TRUEANSWER, TrueAnswer);
        args.putString(ARG_HINT, hint);
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
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFullTheBlankBinding binding = FragmentFullTheBlankBinding.inflate(getLayoutInflater());
        binding.Question1.setText(Question);
        binding.btnChick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.ChecktheAnswer(TrueAnswer,binding.Answer.getText().toString(),3,hint);
            }
        });


        return binding.getRoot();
    }


}
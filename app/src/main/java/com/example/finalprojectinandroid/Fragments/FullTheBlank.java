package com.example.finalprojectinandroid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalprojectinandroid.R;
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
    private static final String ARG_TRUEANSWER = "TrueAnswer";

    // TODO: Rename and change types of parameters
    private String Question;
    private String TrueAnswer;

    public FullTheBlank() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FullTheBlank newInstance(String Question, String TrueAnswer) {
        FullTheBlank fragment = new FullTheBlank();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, Question);
        args.putString(ARG_TRUEANSWER, TrueAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Question = getArguments().getString(ARG_QUESTION);
            TrueAnswer = getArguments().getString(TrueAnswer);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFullTheBlankBinding binding=FragmentFullTheBlankBinding.inflate(getLayoutInflater());
        binding.Question1.setText(Question);
        // Inflate the layout for this fragment




        return binding.getRoot();
    }


}
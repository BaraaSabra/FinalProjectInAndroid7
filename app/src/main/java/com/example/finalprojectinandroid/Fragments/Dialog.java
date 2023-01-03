package com.example.finalprojectinandroid.Fragments;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.finalprojectinandroid.R;
import com.example.finalprojectinandroid.databinding.FragmentDialogBinding;
import com.example.finalprojectinandroid.databinding.FragmentTrueorFalesBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dialog extends DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param1";
    private static final String ARG_HINT = "Hint";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String hint;



    public Dialog() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static Dialog newInstance(String hint) {
        Dialog fragment = new Dialog();
        Bundle args = new Bundle();
        args.putString(ARG_HINT, hint);



        fragment.setArguments(args);
        return fragment;
    }
    public static Dialog newInstance2() {
        Dialog fragment = new Dialog();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            hint = getArguments().getString(ARG_HINT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDialogBinding binding=FragmentDialogBinding.inflate(inflater,container,false);

        binding.messige.setText("The true answer is: "+hint);
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return binding.getRoot() ;

    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


            return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params=getDialog().getWindow().getAttributes();
        params.width=ViewGroup.LayoutParams.MATCH_PARENT;
        params.height=ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams)params);
    }
}
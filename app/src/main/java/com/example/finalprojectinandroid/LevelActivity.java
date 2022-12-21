package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finalprojectinandroid.databinding.ActivityLevelBinding;

public class LevelActivity extends AppCompatActivity {
    ActivityLevelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
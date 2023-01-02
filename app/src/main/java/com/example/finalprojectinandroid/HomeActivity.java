package com.example.finalprojectinandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.finalprojectinandroid.databinding.ActivityHomeBinding;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    Animation BtnStartAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = new Intent(this, MyService.class);


        startService(intent);





        ladlocale();




        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
        BtnStartAn = AnimationUtils.loadAnimation(this,R.anim.btnstart);
        binding.btnStart.setAnimation(BtnStartAn);
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(), LevelActivity.class);
                startActivity(intent);
            }
        });
        binding.imgSeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),SeetingActivity.class);
                startActivity(intent);
            }
        });
        binding.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),ProfileActivity.class);
                startActivity(intent);
            }
        });

        binding.btnLangueg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowChengeLanguageDialog();
            }
        });


    }






    private void ShowChengeLanguageDialog() {
        final  String [] listItems ={"English","Arabic"};
        AlertDialog.Builder mbuiled=new AlertDialog.Builder(HomeActivity.this);
        mbuiled.setTitle("Chooes Language ...");
        mbuiled.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0){
                    setLocale("En");
                    recreate();
                }else if (i == 1){
                    setLocale("Ar");
                    recreate();

                }
            }
        });
        AlertDialog mdialog=mbuiled.create();
        mdialog.show();
    }

    private void setLocale(String en) {
        Locale locale=new Locale(en);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("Setting",MODE_PRIVATE).edit();
        editor.putString("My_lang",en);
        editor.apply();

    }
    private void ladlocale(){
        SharedPreferences sharedPreferences=getSharedPreferences("Setting", Activity.MODE_PRIVATE);
        String language=sharedPreferences.getString("My_Lang","");
        setLocale(language);
    }





}
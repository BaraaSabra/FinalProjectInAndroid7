package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread=new Thread(){
           public void run(){
               try {
                   sleep(3000 );
               }catch (Exception exception){
                   exception.printStackTrace();
               }
               finally {
                   Intent intent=new Intent(getBaseContext(),HomeActivity.class);
                   startActivity(intent);

               }
           }
        };thread.start();

    }
}
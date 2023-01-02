package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.finalprojectinandroid.databinding.ActivitySeetingBinding;

public class SeetingActivity extends AppCompatActivity {
    ActivitySeetingBinding binding;
    Boolean isplaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeetingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        binding.switchMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==false) {
                    Intent intent = new Intent(getBaseContext(), MyService.class);
                    stopService(intent);
                }else {
                    Intent intent = new Intent(getBaseContext(), MyService.class);
                    startService(intent);
                }

            }
        });
        Notification();


    }

    private void Notification() {
        JobScheduler scheduler=(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName componentName=new ComponentName(getBaseContext(),Notification.class);
        JobInfo info=null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
             info=new JobInfo.Builder(1,componentName)
                    //الفرق بين periodic MinaulaLatency mi:بتشغل لمره وحده فقط
//                    .setPeriodic(10*60*1000,5*60*1000)
                     .setMinimumLatency(5000)
                    .build();
        }

        scheduler.schedule(info);


        binding.switchNotifcation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduler.cancel(1);



            }
        });


    }


}

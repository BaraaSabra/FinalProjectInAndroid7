package com.example.finalprojectinandroid;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notification extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("chanal","Chanal name", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Intent intent=new Intent(getBaseContext(),MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(Notification.this,0,intent,0);
        NotificationCompat.Builder builder=
                new NotificationCompat.Builder(Notification.this,"chanal");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentText("Notefiction_text");
        builder.setContentTitle("Notefiction_title");
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.addAction(R.drawable.ic_launcher_background,"Action",pi);
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(Notification.this);
        managerCompat.notify(1,builder.build());
        return false;
    }


    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}

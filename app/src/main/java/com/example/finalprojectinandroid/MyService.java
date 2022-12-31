package com.example.finalprojectinandroid;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyService extends Service {
    MediaPlayer player;
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player= MediaPlayer.create(this,R.raw.ms);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("chanl1","Channel name",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Intent intent1=new Intent(getBaseContext(),HomeActivity.class);
        PendingIntent pi=PendingIntent.getActivity(MyService.this,0,intent1,0);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(MyService.this,"chanl1");
//        builder.addAction(R.drawable.ic_launcher_foreground,"Action",pi);
//        builder.setSmallIcon(R.drawable.ic_launcher_background);
//        builder.setContentTitle("Notification");
//        builder.setContentText("Songe");

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(getBaseContext());
//        managerCompat.notify(1,builder.build());
        startForeground(1,builder.build());
        player.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
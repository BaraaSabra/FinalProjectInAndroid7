package com.example.finalprojectinandroid.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private DaoLevel DaoLevel;
    private LiveData<List<Level>> Alllevel;
    private DaoUsers DaoUsers;
    private LiveData<List<Users>> AllUsers;


    Repository(Application application) {
        Roomdatabase db = Roomdatabase.getDatabase(application);
        DaoLevel = db.DaoLevel();
        Alllevel = DaoLevel.getLevel();
        DaoUsers=db.DaoUser();
        AllUsers=DaoUsers.getUser();
    }


    LiveData<List<Level>> getAlllevel() {
        return Alllevel;
    }


    void insert(Level level) {
        Roomdatabase.databaseWriteExecutor.execute(() -> {
            DaoLevel.insert(level);
        });
    }
    LiveData<List<Users>> getAllUsers() {
        return AllUsers;
    }
    void update(Level level){
        Roomdatabase.databaseWriteExecutor.execute(() -> {
            DaoLevel.insert(level);
        });
    }


    void insert(Users users) {
        Roomdatabase.databaseWriteExecutor.execute(() -> {
            DaoUsers.insert(users);
        });
    }
    void update(Users users){
        Roomdatabase.databaseWriteExecutor.execute(() -> {
            DaoUsers.insert(users);
        });
    }



}

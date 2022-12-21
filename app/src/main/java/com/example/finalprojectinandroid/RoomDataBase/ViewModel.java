package com.example.finalprojectinandroid.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {


        private Repository Repository;

        private final LiveData<List<Level>> AllLevle;
    private final LiveData<List<Users>> AllUser;

        public ViewModel (Application application) {
            super(application);
            Repository = new Repository(application);
            AllLevle = Repository.getAlllevel();
            Repository=new Repository(application);
            AllUser=Repository.getAllUsers();
        }

        LiveData<List<Level>> getAllLevle() {
            return AllLevle;
        }

        public void insert(Level level) {
            Repository.insert(level);
        }

    LiveData<List<Users>> getAllUser() {
        return AllUser;
    }

    public void insert(Users users) {
        Repository.insert(users);
    }

}

package com.example.finalprojectinandroid.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {


         Repository Repository;

        public ViewModel (Application application) {
            super(application);
            Repository = new Repository(application);

        }

    public   void deletLevle(Level level){
      Repository.deletLevle(level);
    }


    public void insertLevle(Level level){
       Repository.insertLevle(level);
    }


    public void updateLevle(Level level){
        Repository.updateLevle(level);
    }

    public LiveData<List<Level>> getLevel(){
        return Repository.getLevel();
    }


    public void insertPuzzleData(PuzzleData puzzleData){
        Repository.insertDaoPuzzleData(puzzleData);
    }



    public  void updatePuzzleData(PuzzleData puzzleData){
       Repository.updatePuzzleData(puzzleData);
    }



    public  void deletPuzzleData(PuzzleData puzzleData){
        Repository.deletPuzzleData(puzzleData);
    }


    public LiveData<List<PuzzleData>> getallpuzzeldata(){
        return Repository.getallpuzzeldata();
    }




    public  LiveData<List<puzzlepatterns>> getpatter_id(int pattern_id ){
        return Repository.getpatter_id(pattern_id);
    }

    public void insertUsers(Users users){
        Repository.insertUsers(users);
    }


    public  void updateUsers(Users users){
        Repository.updateUsers(users);
    }


    public void deleteUsers(Users users){
        Repository.deleteUsers(users);
    }



    public LiveData<List<Users>> getAllUser(){
        return Repository.getAllUser();

    }

    public void insertpuzzlepatterns(puzzlepatterns puzzlepatterns){
        Repository.insertpuzzlepatterns(puzzlepatterns);
    }



    public void updatepuzzlepatterns(puzzlepatterns puzzlepatterns){
        Repository.updatepuzzlepatterns(puzzlepatterns);
    }



    public void deletpuzzlepatterns(puzzlepatterns puzzlepatterns){
        Repository.deletpuzzlepatterns(puzzlepatterns);
    }


    public LiveData<List<puzzlepatterns>> getallpuzzlepatterns(){
        return Repository.getallpuzzlepatterns();
    }

}

package com.example.finalprojectinandroid.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class Repository {
    private DaoLevel DaoLevel;

    private DaoUsers DaoUsers;

    private DaoPuzzleData DaoPuzzleData;
    private  Dappuzzlepatterns Daopuzzlepatterns;


    Repository(Application application) {
        Roomdatabase db = Roomdatabase.getDatabase(application);
        DaoLevel = db.DaoLevel();
        DaoUsers=db.DaoUser();
        DaoPuzzleData=db.DauPuzzledata();
        Daopuzzlepatterns=db.Daupuzzlepatterns();

    }







    void deletLevle(Level level){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoLevel.delete(level);

            }
        });
    }


    void insertLevle(Level level){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoLevel.insert(level);

            }
        });
    }


    void updateLevle(Level level){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoLevel.update(level);

            }
        });
    }

    LiveData<List<Level>> getLevel(){
       return DaoLevel.getLevel();
    }


    void insertDaoPuzzleData(PuzzleData puzzleData){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoPuzzleData.insertPuzzleData(puzzleData);

            }
        });
    }



    void updatePuzzleData(PuzzleData puzzleData){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoPuzzleData.updatePuzzleData(puzzleData);

            }
        });
    }



    void deletPuzzleData(PuzzleData puzzleData){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoPuzzleData.deletPuzzleData(puzzleData);

            }
        });
    }


    LiveData<List<PuzzleData>> getallpuzzeldata(){
        return DaoPuzzleData.getallpuzzeldata();
    }




//    LiveData<List<puzzlepatterns>> getpatter_id(int pattern_id ){
//        return DaoPuzzleData.getpatter_id(pattern_id);
//    }

    void insertUsers(Users users){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoUsers.insertUsers(users);

            }
        });
    }


    void updateUsers(Users users){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoUsers.updateUsers(users);

            }
        });
    }


    void deleteUsers(Users users){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                DaoUsers.deleteUsers(users);

            }
        });
    }



    LiveData<List<Users>> getAllUser(){
        return DaoUsers.getAllUser();

    }

    void insertpuzzlepatterns(puzzlepatterns puzzlepatterns){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Daopuzzlepatterns.insertpuzzlepatterns(puzzlepatterns);

            }
        });
    }



    void updatepuzzlepatterns(puzzlepatterns puzzlepatterns){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Daopuzzlepatterns.updatepuzzlepatterns(puzzlepatterns);

            }
        });
    }



    void deletpuzzlepatterns(puzzlepatterns puzzlepatterns){
        Roomdatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Daopuzzlepatterns.deletpuzzlepatterns(puzzlepatterns);

            }
        });
    }


    LiveData<List<puzzlepatterns>> getallpuzzlepatterns(){
        return Daopuzzlepatterns.getallpuzzlepatterns();
    }





}

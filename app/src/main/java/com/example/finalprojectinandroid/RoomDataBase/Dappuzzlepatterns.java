package com.example.finalprojectinandroid.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public  interface Dappuzzlepatterns {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertpuzzlepatterns(puzzlepatterns puzzlepatterns);


    @Update
    void updatepuzzlepatterns(puzzlepatterns puzzlepatterns);


    @Delete
    void deletpuzzlepatterns(puzzlepatterns puzzlepatterns);

    @Query("select * from puzzlepatterns ORDER BY pattern_id ")
    LiveData<List<puzzlepatterns>> getallpuzzlepatterns();


}

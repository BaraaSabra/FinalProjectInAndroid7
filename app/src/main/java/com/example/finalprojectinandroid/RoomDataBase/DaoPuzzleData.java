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
public interface DaoPuzzleData {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPuzzleData(PuzzleData puzzleData);


    @Update
    void updatePuzzleData(PuzzleData puzzleData);


    @Delete
    void deletPuzzleData(PuzzleData puzzleData);

    @Query("select * from PuzzleData ORDER BY puzzle_number ")
    LiveData<List<PuzzleData>> getallpuzzeldata();

//
//    @Query("select * from puzzledata where pattern_id = :pattern_id")
//
//    LiveData<List<puzzlepatterns>> getpatter_id(int pattern_id );


}

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
public interface DaoLevel {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Level level);

    @Update
    void update(Level level);

    @Delete
    void delete(Level level);


    @Query("select * from Level ")
    LiveData<List<Level>> getLevel();

}

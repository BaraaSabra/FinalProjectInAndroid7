package com.example.finalprojectinandroid.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface DaoLevel {
    @Insert()
    void insert(Level level);

    @Update
    void update(Level level);

    @Delete
    void delete(Level level);


    @Query("select * from Level ORDER BY levelnum DESC ")
    LiveData<List<Level>> getLevel();

}

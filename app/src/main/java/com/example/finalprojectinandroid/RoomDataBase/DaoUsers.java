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
public interface DaoUsers {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUsers(Users users);

    @Update
    void updateUsers(Users users);

    @Delete
    void deleteUsers(Users users);


    @Query("select * from Users ORDER BY id  ")
    LiveData<List<Users>> getAllUser();
}

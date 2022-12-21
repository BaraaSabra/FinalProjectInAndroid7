package com.example.finalprojectinandroid.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface DaoUsers {

    @Insert()
    void insert(Users users);

    @Update
    void update(Users users);

    @Delete
    void delete(Users users);


    @Query("select * from Users ORDER BY id DESC ")
    LiveData<List<Users>> getUser();
}

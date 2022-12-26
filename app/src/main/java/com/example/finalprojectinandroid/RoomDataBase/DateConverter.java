package com.example.finalprojectinandroid.RoomDataBase;

import androidx.room.TypeConverter;

import java.sql.Date;

public class DateConverter {
    @TypeConverter
    public long getLong(Date data){
        return  data.getTime();
    }

    @TypeConverter
    public  Date getData(Long data){
        return  new Date(data);
    }
}



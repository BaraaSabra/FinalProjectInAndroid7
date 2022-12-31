package com.example.finalprojectinandroid.RoomDataBase;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys= {@ForeignKey(entity = Level.class,
        parentColumns = "levelnum", childColumns = "level_num",
        onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)})
public class puzzlepatterns {
    @PrimaryKey(autoGenerate = true)
    int  pattern_id;
    String pattern_name;
    int level_num;


    public puzzlepatterns(int pattern_id, String pattern_name ,int level_num ) {
        this.pattern_id = pattern_id;
        this.pattern_name = pattern_name;
        this.level_num=level_num;

    }


    public int getPattern_id() {
        return pattern_id;
    }

    public void setPattern_id(int pattern_id) {
        this.pattern_id = pattern_id;
    }

    public String getPattern_name() {
        return pattern_name;
    }

    public void setPattern_name(String pattern_name) {
        this.pattern_name = pattern_name;
    }

    public int getLevel_num() {
        return level_num;
    }

    public void setLevel_num(int level_num) {
        this.level_num = level_num;
    }
}

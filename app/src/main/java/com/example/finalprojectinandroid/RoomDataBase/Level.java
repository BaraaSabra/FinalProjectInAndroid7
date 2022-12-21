package com.example.finalprojectinandroid.RoomDataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Level {
    @PrimaryKey
    int levelnum;
    int required_points;

    public Level(int levelnum, int required_points) {
        this.levelnum = levelnum;
        this.required_points = required_points;
    }

    public int getLevelnum() {
        return levelnum;
    }

    public void setLevelnum(int levelnum) {
        this.levelnum = levelnum;
    }

    public int getRequired_points() {
        return required_points;
    }

    public void setRequired_points(int required_points) {
        this.required_points = required_points;
    }
}

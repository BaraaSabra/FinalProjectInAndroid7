package com.example.finalprojectinandroid.RoomDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PuzzleData.class,Users.class,Level.class,puzzlepatterns.class}, version = 1, exportSchema = false)
public abstract class Roomdatabase extends RoomDatabase {

    public abstract DaoLevel DaoLevel();
    public abstract DaoUsers DaoUser();

    private static volatile Roomdatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static Roomdatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Roomdatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    Roomdatabase.class, "Puzzle_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}

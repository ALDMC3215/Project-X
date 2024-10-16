package com.example.video26.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class DatabaseManager extends RoomDatabase {

    public static DatabaseManager databaseManager;

    public static DatabaseManager getDatabaseManager(Context context) {
        if(databaseManager == null) {
            databaseManager = Room.databaseBuilder(context, DatabaseManager.class, "ALDMC_Data")
                    .allowMainThreadQueries()
                    .build();
        }
        return databaseManager;
    }

    public abstract PersonDao getPersonDao();
}


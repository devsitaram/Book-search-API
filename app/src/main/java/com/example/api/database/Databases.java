package com.example.api.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = PostPojo.class, version = 1)
public abstract class Databases extends RoomDatabase {
    public static Databases instance;
    private static final String DB_NAME = "UserDatabase";

    public static synchronized Databases getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context, Databases.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return (Databases) instance;
    }

    // create the abstract methods
    public abstract BookDao booksDao();

}

package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Note.class},version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NoteStore noteStore();

    private static final String DB_NAME = "notes.db";
    private static volatile NotesDatabase INSTANCE=null;

    public synchronized static NotesDatabase get(Context context){
        if(INSTANCE==null){
            INSTANCE=create(context,false);
        }
        return INSTANCE;
    }

    public static NotesDatabase create(Context context, boolean memoryOnly) {

        RoomDatabase.Builder<NotesDatabase> b;
        if(memoryOnly){
            b= Room.inMemoryDatabaseBuilder(context,NotesDatabase.class);

        }
        else{
            b=Room.databaseBuilder(context,NotesDatabase.class,DB_NAME);
        }
        return b.build();
    }


}

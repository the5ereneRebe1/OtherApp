package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NoteStore {
    @Query("SELECT * FROM notes ORDER BY title")
    List<Note> selectAll();
    @Query("SELECT * FROM notes WHERE id=:id")
    Note getANote(String id);
    @Insert
    void insert(Note... notes);
    @Update
    void update(Note... notes);
    @Delete
    void delete(Note... notes);

}

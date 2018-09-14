package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;
@Entity(tableName = "courses")
public class Course {
    @PrimaryKey
    @NonNull
    public final String id;
    public final String title;
    @Ignore
    public Course(String title){
        this(UUID.randomUUID().toString(),title);
    }
    public Course(String id, String title) {
        this.id = id;
        this.title = title;
    }
}

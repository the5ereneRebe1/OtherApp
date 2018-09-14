package com.example.himanshu.otherapp.RoomDB2;

import android.arch.persistence.room.PrimaryKey;

import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.himanshu.otherapp.RoomDB.Priority;

import java.util.Date;
import java.util.UUID;

public class Plan {

    @PrimaryKey
    @NonNull
    public final String id;
    public final String title;
    public final int duration;
    @TypeConverters({Priority.class})
    public final Priority priority;

    public final Date startTime;
    public final Date creationTime;
    public final Date updateTime;

    public Plan(String title,int duration,Priority priority,Date startTime){
        this(UUID.randomUUID().toString(),title,duration,priority,startTime,null,null);
    }
    public Plan(@NonNull String id, String title, int duration, Priority priority, Date startTime, Date creationTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.priority = priority;
        this.startTime = startTime;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }
}

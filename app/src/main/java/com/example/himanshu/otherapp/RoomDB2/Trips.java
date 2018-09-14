package com.example.himanshu.otherapp.RoomDB2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.himanshu.otherapp.RoomDB.DataConvertors;
import com.example.himanshu.otherapp.RoomDB.Priority;

import java.util.Date;
@Entity(tableName = "trips")
@TypeConverters({DataConvertors.class})
public class Trips extends Plan {

    public Trips(String title, int duration, Priority priority, Date startTime) {
        super(title, duration, priority, startTime);
    }

    public Trips(@NonNull String id, String title, int duration, Priority priority, Date startTime, Date creationTime, Date updateTime) {
        super(id, title, duration, priority, startTime, creationTime, updateTime);
    }
}

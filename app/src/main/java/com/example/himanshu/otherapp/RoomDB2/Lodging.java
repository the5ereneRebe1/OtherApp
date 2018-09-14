package com.example.himanshu.otherapp.RoomDB2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

import com.example.himanshu.otherapp.RoomDB.Priority;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "lodging",
foreignKeys = @ForeignKey(entity = Trips.class, parentColumns = "id",childColumns = "tripId",onDelete = CASCADE),
indices = @Index("tripId"))
public class Lodging extends Plan {

    public final String address;
    public final String tripId;


    public Lodging(String address, String tripId,String title, int duration, Priority priority, Date startTime) {
        super(title, duration, priority, startTime);
        this.address = address;
        this.tripId = tripId;
    }

    public Lodging(@NonNull String id, String title, int duration, Priority priority, Date startTime, Date creationTime, Date updateTime, String address, String tripId) {
        super(id, title, duration, priority, startTime, creationTime, updateTime);
        this.address = address;
        this.tripId = tripId;
    }
}

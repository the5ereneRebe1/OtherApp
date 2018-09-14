package com.example.himanshu.otherapp.RoomDB2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

import com.example.himanshu.otherapp.RoomDB.Priority;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "flights",
        foreignKeys = @ForeignKey(entity = Trips.class,parentColumns = "id",childColumns = "tripId",onDelete = CASCADE),
        indices = @Index("tripId")
)
public class Flights extends Plan {

public final String departingAirport;
public final String arrivingAirport;
public final String airlineCode;
public final String flightNumber;
public final String seatNumber;

public final String tripId;

    public Flights(String title, int duration, Priority priority, Date startTime, String departingAirport, String arrivingAirport, String airlineCode, String flightNumber, String seatNumber, String tripId) {
        super(title, duration, priority, startTime);
        this.departingAirport = departingAirport;
        this.arrivingAirport = arrivingAirport;
        this.airlineCode = airlineCode;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.tripId = tripId;
    }

    public Flights(@NonNull String id, String title, int duration, Priority priority, Date startTime, Date creationTime, Date updateTime, String departingAirport, String arrivingAirport, String airlineCode, String flightNumber, String seatNumber, String tripId) {
        super(id, title, duration, priority, startTime, creationTime, updateTime);
        this.departingAirport = departingAirport;
        this.arrivingAirport = arrivingAirport;
        this.airlineCode = airlineCode;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.tripId = tripId;
    }
}

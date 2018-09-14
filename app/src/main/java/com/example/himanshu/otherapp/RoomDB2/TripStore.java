package com.example.himanshu.otherapp.RoomDB2;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.himanshu.otherapp.RoomDB.Note;

import java.util.List;

@Dao
public interface TripStore {
    @Query("SELECT * FROM trips ORDER BY title")
    List<Trips> selectAll();
    @Query("SELECT * FROM trips WHERE id=:id")
    Note getATrip(String id);
    @Insert
    void insert(Trips... trips);
    @Update
    void update(Trips... trips);
    @Delete
    void delete(Trips... trips);

    //Lodging

    @Query("SELECT * FROM lodging WHERE tripId=:tripId")
    List<Lodging> findLodgingForTrip(String tripId);

    @Insert
    void insert(Lodging... lodgings);
    @Update
    void update(Lodging... lodgings);
    @Delete
    void delete(Lodging... lodgings);

    //Flights
    @Query("SELECT * FROM flights WHERE tripId=:tripId")
    List<Flights> findFlightsForTrip(String tripId);
    @Insert
    void insert(Flights... flights);
    @Update
    void update(Flights... flights);
    @Delete
    void delete(Flights... flights);


}

package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "notes",
        foreignKeys = @ForeignKey(entity = Course.class,parentColumns = "id",childColumns = "courseId",onDelete = CASCADE),
        indices = @Index("courseId"))
public class Note {
    @PrimaryKey
    @NonNull
    public final String id;
    public final String title;
    public final String text;
    public  Date date;
    public final Set<String> tags;
    @TypeConverters({Priority.class})
    public final Priority priority;
    public final String courseId;
    /*
    If we have two embedded columns of the same type to avoid having multiple
            latitude and longitude columns we optionally add the parameter prefix to the annotation.*/
    @Embedded(prefix = "_notes")
    public LocationColumns location;
    @Ignore
    public Note(String title, String text, Set<String> tags, LocationColumns location, Priority priority, String courseId){
        this(UUID.randomUUID().toString(),title,text,tags,location,priority, courseId);

    }

    public Set<String> getTags() {
        return tags;
    }


    public Note(@NonNull String id, String title, String text, Set<String> tags, LocationColumns location, Priority priority, String courseId) {
        this.id=id;
        this.title=title;
        this.text=text;
        this.courseId = courseId;
        date= Calendar.getInstance().getTime();
        this.tags=tags;
        this.location=location;
        this.priority=priority;
    }


    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return title;
    }

    public Date getDate() {
        return date;
    }


}

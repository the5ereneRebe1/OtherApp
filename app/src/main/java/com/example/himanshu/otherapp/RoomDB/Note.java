package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey
    @NonNull
    public final String id;
    public String title;
    public String text;
    public Date date;
    public Set<String> tags;
    @TypeConverters({Priority.class})
    public Priority priority;
    /*
    If we have two embedded columns of the same type to avoid having multiple
            latitude and longitude columns we optionally add the parameter prefix to the annotation.*/
    @Embedded(prefix = "_notes")
    public LocationColumns location;
    @Ignore
    public Note(String title, String text,Set<String> tags,LocationColumns location,Priority priority){
        this(UUID.randomUUID().toString(),title,text,tags,location,priority);

    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Note(@NonNull String id, String title, String text, Set<String> tags, LocationColumns location, Priority priority) {
        this.id=id;
        this.title=title;
        this.text=text;
        date= Calendar.getInstance().getTime();
        this.tags=tags;
        this.location=location;
        this.priority=priority;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

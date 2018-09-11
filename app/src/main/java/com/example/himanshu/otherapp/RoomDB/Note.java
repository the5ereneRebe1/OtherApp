package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
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
    @Ignore
    public Note(String title, String text,Set<String> tags){
        this(UUID.randomUUID().toString(),title,text,tags);

    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Note(@NonNull String id, String title, String text, Set<String> tags) {
        this.id=id;
        this.title=title;
        this.text=text;
        date= Calendar.getInstance().getTime();
        this.tags=tags;
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

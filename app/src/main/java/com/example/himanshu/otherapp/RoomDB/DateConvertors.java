package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConvertors {

    @TypeConverter
    public Long dateToTimestamp(Date date){
        if(date==null) return null;
        return date.getTime();
    }
    @TypeConverter
    public Date toDate(Long time){
        if(time==null) return null;
        return new Date(time);
    }
}

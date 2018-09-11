package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.TypeConverter;

public enum  Priority {
    LOW(0),MEDIUM(1),HIGH(1),OMG(1);
    int level;
    Priority(int level) {
        this.level=level;
    }

    @TypeConverter
    public static Priority fromLevel(Integer level){
        for(Priority p : values()){
            if(p.level==level)
                return p;
        }
        return null;
    }
    @TypeConverter
    public static Integer fromPriority(Priority p ){
        if(p==null) return null;
        else return p.level;
    }
}

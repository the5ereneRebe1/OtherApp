package com.example.himanshu.otherapp.RoomDB;

import android.arch.persistence.room.TypeConverter;
import android.util.JsonReader;
import android.util.JsonWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DataConvertors {

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
    @TypeConverter
    public String setToString(Set<String> tags){
        if(tags==null) return null;
        StringWriter writer =new StringWriter();
        JsonWriter jsonWriter =new JsonWriter(writer);
        try{
            jsonWriter.beginArray();
            for(String s : tags){
                jsonWriter.value(s);
            }
            jsonWriter.endArray();
            jsonWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
    @TypeConverter
    public Set<String> stringToSet(String jsonParse){
        if(jsonParse==null) return null;
        StringReader reader =new StringReader(jsonParse);
        JsonReader jsonReader =new JsonReader(reader);
        HashSet<String> set =new HashSet<>();
        try{
         jsonReader.beginArray();
         while(jsonReader.hasNext()){
             set.add(jsonReader.nextString());
         }
         jsonReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}

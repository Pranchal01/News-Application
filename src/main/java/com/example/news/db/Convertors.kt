package com.example.news.db

import androidx.room.TypeConverter
import com.example.news.models.Source
import java.security.CodeSource
import java.util.*

class Convertors {

    // because our article class has one data of type
    // Source and room only understands primitive data types so
    // we need to make a convector to convert source to primitive or vise-versa
   @TypeConverter
    fun fromSource(source: Source) : String
    {
        return source.name
    }
    @TypeConverter
    fun toSource(name:String):Source
    {
        return Source(name,name)
    }

}
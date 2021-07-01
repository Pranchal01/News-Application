package com.example.news.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


// database class for room needs to be abstract.
@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(Convertors::class)
abstract class ArticleDatabase : RoomDatabase(){

    abstract fun getArticleDao():   ArticleDao

    // object inside class has to be prefix by companion keyword.
    companion object{
        @Volatile                   // any change in instance will be immediacy be visible to other threads.
        private var instance:ArticleDatabase?=null
        private var LOCK=Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance ?: createDatabase(context).also{ instance = it}
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db").build()
    }

}
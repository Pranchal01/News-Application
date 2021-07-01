package com.example.news.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.news.models.Source
import java.io.Serializable


// creating entity for room database so that saved articles can be read and saved in local db.

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable{}
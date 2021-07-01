package com.example.news.respository

import com.example.news.api.RetrofitInstance
import com.example.news.db.Article
import com.example.news.db.ArticleDatabase

class NewsRepository (
    val db:ArticleDatabase){

    // as network function is suspend func hence it can be executed only inside another suspend
    // function or inside a coroutine.

    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) = RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)
    suspend fun searchNews(searchQuery: String, pageNumber: Int) = RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    // ArticleDAO functions.
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
    fun getSavedNews() = db.getArticleDao().getAllArticles()
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}
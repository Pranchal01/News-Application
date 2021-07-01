package com.example.news.api

import com.example.news.models.NewsResponse
import com.example.news.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


// This interface is used to define single request.
interface NewsAPI {
    // HTTP get request for breaking news.
    // part after the base URL in get parenthesis.
    @GET("v2/top-headlines")

//    we want to create a function which gets our breaking news.
//    as this is a network call hence will take quite a time hence we need a coroutine
//    for doing this and by creating a ***suspend function*** which works only inside a
//    coroutine.
    suspend fun getBreakingNews(
          @Query("country" ) // In this func we need parameters example for which
          countryCode:String = "in",     // country we want to show news. So annotate this request
                                        // parameter with @Query
        // Now we don't want all the result at same time
//    but we need to paginate each query for one page result at a time.
        @Query("page")
        pageNumber:Int =1,
          @Query("apiKey")
          apiKey:String = API_KEY       // this API_KEY is defined in
    ) : Response<NewsResponse>      // we want a response to return of type NewsResponse. Kotlin class



//    similarly we want to create a suspend function for search queries.
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int=1,
        @Query("apiKey")
        apiKey: String= API_KEY
    ):Response<NewsResponse>


    // after this we need to create a retrofit singleton class which lets us to make request from everywhere in code.
}
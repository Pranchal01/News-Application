package com.example.news.api

import com.example.news.utils.Constants.Companion.BASE_URL
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
//    object(static in java) inside a class has to be prefixed with the keyword companion.
    companion object{
        private val retrofit by lazy {                  // here lazy means jb iska use aayega tb hi isko initialise liya jyega.
            val logging =HttpLoggingInterceptor()       // this is helpful in logging retrofit responses in logcat.
                                                        // HttpLoggingInterceptor is from "com.squareup.okhttp3:logging-interceptor:4.5.0" this dependency in build.gradle
            logging.setLevel(HttpLoggingInterceptor.Level.BODY) // this line means we need body of the response.
            val client = OkHttpClient.Builder().addInterceptor(logging).build()
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build()
        }

    val api by lazy {
        retrofit.create(NewsAPI::class.java)
    }
    }
}
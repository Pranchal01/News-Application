package com.example.news.utils


// This class is used to handel success and error responses in Network calls.
//Sealed class is class which can mention strictly which all classes will be allowed to inherit from this class.
sealed class Resource<T>(
    val data:T ?=null,
val message:String ?=null
) {
    class Success<T>(data: T):Resource<T>(data)
    class Error<T>(message: String?,data: T?= null):Resource<T>(data,message)
    class Loading<T> : Resource<T>()
}
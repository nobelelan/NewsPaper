package com.parulson.newspaper.util

sealed class Resource<T>(//sealed class is an abstract class but sealed class can give access to specific classes it wants
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T?= null): Resource<T>(data, message)
    class Loading<T>: Resource<T>()
}
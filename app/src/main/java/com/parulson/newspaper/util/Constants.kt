package com.parulson.newspaper.util

class Constants {
    //companion object lets us to not create an instance of the class
    companion object{
        const val API_KEY = "40bd27dec5664f2d9b115adcb7bb3cc8" //never ever publish this api key
        const val BASE_URL = "https://newsapi.org/"
        const val SEARCH_NEWS_TIME_DELAY = 500L
        const val QUERY_PAGE_SIZE = 20
    }
}
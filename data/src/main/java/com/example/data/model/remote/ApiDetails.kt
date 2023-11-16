package com.example.data.model.remote


object ApiDetails {



        const val BASE_URL = "https://newsapi.org/v2/"
        const val END_POINT = "everything"

        // All BBC News
        //"https://newsapi.org/v2/everything?q=bbc&apiKey=65ee5ba175334615ad526df29802177e"
        const val BBCNEWS = "bbc"

        // All News on Africa
        //"https://newsapi.org/v2/everything?q=africa&apiKey=65ee5ba175334615ad526df29802177e"
        const val AFRICANEWS = "africa"

        // All Business Insider News
        //"https://newsapi.org/v2/everything?q=business-insider&apiKey=65ee5ba175334615ad526df29802177e"

        const val BUSINESSINSIDER = "business-insider"

        // News About Donald Trump.
        //"https://newsapi.org/v2/top-headlines?q=trump&apiKey=65ee5ba175334615ad526df29802177e"

        const val DONALDTRUMP = "trump"

        val API_KEY = "65ee5ba175334615ad526df29802177e"

}

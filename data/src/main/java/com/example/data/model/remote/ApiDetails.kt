package com.example.data.model.remote


object ApiDetails {
        const val BASE_URL = "https://newsapi.org/v2/everything?"

        // All BBC News
        //"https://newsapi.org/v2/everything?q=bbc&apiKey=65ee5ba175334615ad526df29802177e"
        const val BBCNEWS_ENDPOINT = "q=bbc"

        // All News on Africa
        //"https://newsapi.org/v2/everything?q=africa&apiKey=65ee5ba175334615ad526df29802177e"
        const val AFRICANEWS_ENDPOINT = "q=africa"

        // All Business Insider News
        //"https://newsapi.org/v2/everything?q=business-insider&apiKey=65ee5ba175334615ad526df29802177e"

        const val BUSINESSINSIDER_ENDPOINT = "q=business-insider"

        // News About Donald Trump.
        //"https://newsapi.org/v2/top-headlines?q=trump&apiKey=65ee5ba175334615ad526df29802177e"

        const val DONALDTRUMP_ENDPOINT = "q=trump"

        val API_KEY = "65ee5ba175334615ad526df29802177e"

}

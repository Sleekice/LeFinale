package com.example.data.model.remote

import com.example.data.model.remote.africanews.AfricanNewsDataModel
import com.example.data.model.remote.bbcnews.BBCNewsDataModel
import com.example.data.model.remote.businessinsider.BusinessInsiderDataModel
import com.example.data.model.remote.donaldtrumpnews.DonaldTrumpDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {


    //All BBC News
    @GET(ApiDetails.BASE_URL)
    suspend fun getAllBBCNews(
        @Query("q")
        query: String = ApiDetails.BBCNEWS_ENDPOINT,
        @Query("apiKey")
        appid: String = ApiDetails.API_KEY
    ): Response<BBCNewsDataModel>

    //All News on Africa
    @GET(ApiDetails.BASE_URL)
    suspend fun getAllAfricanNews(
        @Query("q")
        query: String = ApiDetails.AFRICANEWS_ENDPOINT,
        @Query("apiKey")
        appid: String = ApiDetails.API_KEY
    ): Response<AfricanNewsDataModel>

    //All Business Insider News
    @GET(ApiDetails.BASE_URL)
    suspend fun getAllBusinessInsiderNews(
        @Query("q")
        query: String = ApiDetails.BUSINESSINSIDER_ENDPOINT,
        @Query("apiKey")
        appid: String = ApiDetails.API_KEY
    ): Response<BusinessInsiderDataModel>

    //All Donald Trump News
    @GET(ApiDetails.BASE_URL)
    suspend fun getAllDonaldTrumpNews(
        @Query("q")
        query: String = ApiDetails.DONALDTRUMP_ENDPOINT,
        @Query("apiKey")
        appid: String = ApiDetails.API_KEY
    ): Response<DonaldTrumpDataModel>


}
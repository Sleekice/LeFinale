package com.example.data.model.remote

import com.example.data.model.remote.ApiDetails.AFRICANEWS
import com.example.data.model.remote.ApiDetails.BBCNEWS
import com.example.data.model.remote.ApiDetails.BUSINESSINSIDER
import com.example.data.model.remote.ApiDetails.DONALDTRUMP
import com.example.data.model.remote.africanews.AfricanNewsDataModel
import com.example.data.model.remote.bbcnews.BBCNewsDataModel
import com.example.data.model.remote.businessinsider.BusinessInsiderDataModel
import com.example.data.model.remote.donaldtrumpnews.DonaldTrumpDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {


    //All BBC News
    @GET(ApiDetails.END_POINT)
    suspend fun getAllBBCNews(
        @Query("q")
        query: String = BBCNEWS,
        @Query("apiKey")
        apiKey: String = ApiDetails.API_KEY
    ): Response<BBCNewsDataModel>

    //All News on Africa
    @GET(ApiDetails.END_POINT)
    suspend fun getAllAfricanNews(
        @Query("q")
        query: String = AFRICANEWS,
        @Query("apiKey")
        apiKey: String = ApiDetails.API_KEY
    ): Response<AfricanNewsDataModel>

    //All Business Insider News
    @GET(ApiDetails.END_POINT)
    suspend fun getAllBusinessInsiderNews(
        @Query("q")
        query: String = BUSINESSINSIDER,
        @Query("apiKey")
        apiKey: String = ApiDetails.API_KEY
    ): Response<BusinessInsiderDataModel>

    //All Donald Trump News
    @GET(ApiDetails.END_POINT)
    suspend fun getAllDonaldTrumpNews(
        @Query("q")
        query: String = DONALDTRUMP,
        @Query("apiKey")
        apiKey: String = ApiDetails.API_KEY
    ): Response<DonaldTrumpDataModel>


}
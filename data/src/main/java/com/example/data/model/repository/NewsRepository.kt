package com.example.data.model.repository

import com.example.data.model.remote.ApiDetails
import com.example.data.model.remote.africanews.AfricanNewsDataModel
import com.example.data.model.remote.bbcnews.BBCNewsDataModel
import com.example.data.model.remote.businessinsider.BusinessInsiderDataModel
import com.example.data.model.remote.donaldtrumpnews.DonaldTrumpDataModel
import retrofit2.Response


interface NewsRepository {

    // All BBC News
    suspend fun getAllBBCNews(query: String = ApiDetails.BBCNEWS_ENDPOINT): Response<BBCNewsDataModel>

    // All News on Africa
    suspend fun getAllAfricanNews(query: String = ApiDetails.AFRICANEWS_ENDPOINT): Response<AfricanNewsDataModel>

    // All Business Insider News
    suspend fun getAllBusinessInsiderNews(query: String = ApiDetails.BUSINESSINSIDER_ENDPOINT): Response<BusinessInsiderDataModel>

    // All Donald Trump News
    suspend fun getAllDonaldTrumpNews(query: String = ApiDetails.DONALDTRUMP_ENDPOINT): Response<DonaldTrumpDataModel>

}



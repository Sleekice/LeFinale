package com.example.data.model.repository

import com.example.data.model.remote.NewsService
import com.example.data.model.remote.africanews.AfricanNewsDataModel
import com.example.data.model.remote.bbcnews.BBCNewsDataModel
import com.example.data.model.remote.businessinsider.BusinessInsiderDataModel
import com.example.data.model.remote.donaldtrumpnews.DonaldTrumpDataModel
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl@Inject constructor(
    private val newsService: NewsService)
    : NewsRepository {

    override suspend fun getAllBBCNews(query: String): Response<BBCNewsDataModel> {
        return newsService.getAllBBCNews(query)
    }

    override suspend fun getAllAfricanNews(query: String): Response<AfricanNewsDataModel> {
        return newsService.getAllAfricanNews(query)
    }

    override suspend fun getAllBusinessInsiderNews(query: String): Response<BusinessInsiderDataModel> {
        return newsService.getAllBusinessInsiderNews(query)
    }

    override suspend fun getAllDonaldTrumpNews(query: String): Response<DonaldTrumpDataModel> {
        return newsService.getAllDonaldTrumpNews(query)
    }
}

package com.example.data.model.util

import com.example.data.model.local.NewsEntity
import com.example.data.model.remote.africanews.ArticleModel
import javax.inject.Inject

class NetworkMapper @Inject constructor() {

    fun mapToDomainModel(dto: NewsEntity): ArticleModel {
        return ArticleModel(
            author = dto.author,
            content = dto.content,
            description  = dto.description,
            publishedAt = dto.publishedAt,
            source = dto.source,
            title = dto.title,
            url = dto.url,
            urlToImage = dto.urlToImage

        )
    }

    fun mapToDomainModelList(dtos: List<NewsEntity>): List<ArticleModel> {
        return dtos.map { mapToDomainModel(it) }
    }
}

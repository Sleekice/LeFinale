package com.example.data.model.util

import com.example.data.model.local.NewsEntity
import com.example.data.model.remote.africanews.ArticleModel
import javax.inject.Inject

class CacheMapper @Inject constructor() {

    fun mapFromEntity(entity: NewsEntity): ArticleModel {
        return ArticleModel(
            author = entity.author,
            content = entity.content,
            description  = entity.description,
            publishedAt = entity.publishedAt,
            source = entity.source,
            title = entity.title,
            url = entity.url,
            urlToImage = entity.urlToImage
        )
    }

    fun mapToEntity(domainModel: ArticleModel): NewsEntity {
        return NewsEntity(
            author = domainModel.author,
            content = domainModel.content,
            description  = domainModel.description,
            publishedAt = domainModel.publishedAt,
            source = domainModel.source,
            title = domainModel.title,
            url = domainModel.url,
            urlToImage = domainModel.urlToImage
        )
    }

    fun mapFromEntityList(entities: List<NewsEntity>): List<ArticleModel> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(domainModels: List<ArticleModel>): List<NewsEntity> {
        return domainModels.map { mapToEntity(it) }
    }
}
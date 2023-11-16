package com.example.lefinale.presentation.screens.home.bbcnewstab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.data.model.remote.ApiDetails
import com.example.lefinale.presentation.components.BBCNewsCard
import com.example.lefinale.presentation.viewmodels.NewsViewModel

@Composable
fun displayBBCNewsContent(viewModel: NewsViewModel) {

    val bbcNewsData by viewModel.bbcNewsData.collectAsState()

    viewModel.getAllBBCNews(ApiDetails.BBCNEWS)

    bbcNewsData?.let {
        LazyColumn {
            items(it.articles.orEmpty()) { article ->
                BBCNewsCard(
                    imageUrl = article?.urlToImage ?: "",
                    title = article?.title ?: "",
                    description = article?.description ?: "",
                    date = article?.publishedAt ?: "",
                    source = article?.source?.name ?: "",
                    onClick = {
                        // Set the selected article in the view model
                       // viewModel.setSelectedArticle(article)
                    }

                )
            }
        }
    }
}
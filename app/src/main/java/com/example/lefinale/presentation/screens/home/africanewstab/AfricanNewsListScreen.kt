package com.example.lefinale.presentation.screens.home.africanewstab


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.data.model.remote.ApiDetails
import com.example.lefinale.presentation.components.AfricanNewsCard
import com.example.lefinale.presentation.viewmodels.NewsViewModel


@Composable
fun displayAfricanNewsContent(viewModel: NewsViewModel) {

    val africanNewsData by viewModel.africanNewsData.collectAsState()
    viewModel.getAllAfricanNews(ApiDetails.AFRICANEWS)
    africanNewsData?.let {
        LazyColumn {
            items(it.articles.orEmpty()) { article ->
                AfricanNewsCard(
                    imageUrl = article?.urlToImage ?: "",
                    title = article?.title ?: "",
                    description = article?.description ?: "",
                    date = article?.publishedAt ?: "",
                    source = article?.source?.name ?: ""
                )
            }
        }
    }
}



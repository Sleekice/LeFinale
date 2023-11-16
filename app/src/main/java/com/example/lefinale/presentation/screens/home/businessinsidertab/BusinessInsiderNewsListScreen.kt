package com.example.lefinale.presentation.screens.home.businessinsidertab


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.data.model.remote.ApiDetails
import com.example.lefinale.presentation.components.BusinessInsiderNewsCard
import com.example.lefinale.presentation.viewmodels.NewsViewModel

@Composable
fun displayBusinessInsiderNewsContent(viewModel: NewsViewModel) {
    val businessInsiderData by viewModel.businessInsiderData.collectAsState()


    val isLoading by viewModel.businessInsiderLoading


    viewModel.getAllBusinessInsiderNews(ApiDetails.BUSINESSINSIDER)
    businessInsiderData?.let {
        LazyColumn {
            items(it.articles.orEmpty()) { article ->
                BusinessInsiderNewsCard(
                    imageUrl = article?.urlToImage ?: "",
                    title = article?.title ?: "",
                    date = article?.publishedAt ?: "",
                    source = article?.source?.name ?: "",
                    isLoading = isLoading // Pass the isLoading value
                )
            }
        }
    }
}
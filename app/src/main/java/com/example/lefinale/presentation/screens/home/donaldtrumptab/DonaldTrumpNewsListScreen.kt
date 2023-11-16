package com.example.lefinale.presentation.screens.home.donaldtrumptab

import com.example.lefinale.presentation.components.DonaldTrumpNewsCard

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.data.model.remote.ApiDetails
import com.example.lefinale.presentation.viewmodels.NewsViewModel

@Composable
fun displayDonaldTrumpNewsContent(viewModel: NewsViewModel) {
    val donaldTrumpData by viewModel.donaldTrumpData.collectAsState()


    viewModel.getAllDonaldTrumpNews(ApiDetails.DONALDTRUMP)

    donaldTrumpData?.let {
                LazyColumn {
                    items(it.articles.orEmpty()) { article ->
                        DonaldTrumpNewsCard(
                            imageUrl = article?.urlToImage?:"",//R.drawable.img, // Replace with actual image resource or URL
                            title = article?.title ?: "",
                            date = article?.publishedAt ?: "",
                            source = article?.source?.name ?: ""
                        )
                    }
                }}

}
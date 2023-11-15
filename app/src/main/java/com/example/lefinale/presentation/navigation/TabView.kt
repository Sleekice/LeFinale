package com.example.lefinale.presentation.navigation

import NewsViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lefinale.R
import com.example.lefinale.presentation.components.NewsCard


@Composable
fun TabView(selectedIndex: Int,
            onTabSelected: (Int) -> Unit, ) {



    TabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = Color.White
    ) {
        Tab(
            selected = selectedIndex == 0,

            onClick = { onTabSelected(0) }

        ) {
            //icon = Icons.Filled.Newspaper,
            Text("BBC")
        }
        Tab(
            selected = selectedIndex == 1,
            onClick = { onTabSelected(1) }
        ) {
            Text("Africa")
        }
        Tab(
            selected = selectedIndex == 2,
            onClick = { onTabSelected(2) }
        ) {
            Text("Bussiness Insider")
        }
        Tab(
            selected = selectedIndex == 3,
            onClick = { onTabSelected(3) }
        ) {
            Text("Trump")
        }
    }

}

@Composable
fun MainContent(selectedIndex: Int) {
    var viewModel = hiltViewModel<NewsViewModel>()

    when (selectedIndex) {
        0 -> {
            // Display BBC News
            val bbcNewsData by viewModel.bbcNewsData.collectAsState()
            bbcNewsData?.let {
                LazyColumn {
                    items(it.articles.orEmpty()) { article ->
                        NewsCard(
                            imageUrl = R.drawable.img, // Replace with actual image resource or URL
                            title = article?.title ?: "",
                            description = article?.description ?: "",
                            date = article?.publishedAt ?: "",
                            source = article?.source?.name ?: ""
                        )
                    }
                }
            }
        }
        1 -> {
            // Display Africa News
            // Similar logic as above for other tabs
        }
        // ... other tab cases ...
    }
}
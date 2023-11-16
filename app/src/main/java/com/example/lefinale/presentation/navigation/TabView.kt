package com.example.lefinale.presentation.navigation

import com.example.lefinale.presentation.viewmodels.NewsViewModel
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lefinale.presentation.screens.home.africanewstab.displayAfricanNewsContent
import com.example.lefinale.presentation.screens.home.bbcnewstab.displayBBCNewsContent
import com.example.lefinale.presentation.screens.home.businessinsidertab.displayBusinessInsiderNewsContent
import com.example.lefinale.presentation.screens.home.donaldtrumptab.displayDonaldTrumpNewsContent


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
            displayBBCNewsContent(viewModel)
        }
        1 -> {
            displayAfricanNewsContent(viewModel)
        }
        2 -> {
           // displayBBCNewsContent(viewModel)
            displayBusinessInsiderNewsContent(viewModel)
        }
        3 -> {
            displayDonaldTrumpNewsContent(viewModel)
        }
        // ... other tab cases ...
    }
}



// Display BBC News
/**            val bbcNewsData by viewModel.bbcNewsData.collectAsState()
//            viewModel.getAllBBCNews(ApiDetails.BBCNEWS)
//            bbcNewsData?.let {
//                LazyColumn {
//                    items(it.articles.orEmpty()) { article ->
//                        NewsCard(
//                            imageUrl = article?.urlToImage?:"",//R.drawable.img, // Replace with actual image resource or URL
//                            title = article?.title ?: "",
//                            description = article?.description ?: "",
//                            date = article?.publishedAt ?: "",
//                            source = article?.source?.name ?: ""
//                        )
//                    }
//                }}
 **/
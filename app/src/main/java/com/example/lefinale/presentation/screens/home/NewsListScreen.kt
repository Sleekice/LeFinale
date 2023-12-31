package com.example.lefinale.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lefinale.R
import com.example.lefinale.presentation.navigation.MainContent
import com.example.lefinale.presentation.navigation.TabView
import com.example.lefinale.presentation.viewmodels.NewsViewModel

@Composable
fun NewsListScreen(
    navController: NavController,
   // viewModel: NewsViewModel

) {
    var selectedTabIndex by remember { mutableStateOf(0) }

//
//    val selectedArticle by viewModel.selectedArticle.collectAsState()
//
//    DisposableEffect(selectedArticle) {
//        if (selectedArticle != null) {
//            navController.navigate("details/${selectedArticle?.title}")
//        }
//        onDispose {
//            // Clear the selected article when the NewsListScreen is disposed
//            viewModel.clearSelectedArticle()
//        }
//    }


    Column {}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.each_tap_one_story),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 10.dp),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Thin,
                textAlign = TextAlign.Start
            )

            TabView(selectedTabIndex, { index ->
                selectedTabIndex = index
            })

            MainContent(selectedTabIndex)
        }
    }
}
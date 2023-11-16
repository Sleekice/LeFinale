package com.example.lefinale.presentation.screens.home.bbcnewstab

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.lefinale.presentation.viewmodels.NewsViewModel


@Composable
fun BBCNewsDetailScreen (navController: NavController,viewModel: NewsViewModel){
        val selectedArticle by viewModel.selectedArticle.collectAsState()

        // Check if the selected article is not null
        if (selectedArticle != null) {
            // Render the detail screen with the selected article details
            // ...

            // Add a back button to navigate back to the NewsListScreen
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }else {
            // Render UI when no article is selected
        }
    }



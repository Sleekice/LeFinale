package com.example.lefinale.presentation

import NewsViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.lefinale.presentation.components.NewsCard
import com.example.lefinale.presentation.navigation.MainScreen
import com.example.lefinale.presentation.screens.profile.ProfileScreen
import com.example.lefinale.presentation.ui.theme.LeFinaleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsViewModel: NewsViewModel by viewModels()

        setContent {
            LeFinaleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                    //NewsCard()
                }
            }
        }
    }
}


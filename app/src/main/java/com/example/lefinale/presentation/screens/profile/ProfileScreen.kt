package com.example.lefinale.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen (navController: NavController){
    //navController: NavController


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Gray)
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(
                text = "Profile  Screen",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}
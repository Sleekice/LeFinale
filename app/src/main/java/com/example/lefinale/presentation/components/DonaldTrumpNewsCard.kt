package com.example.lefinale.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.lefinale.R

@Composable
fun DonaldTrumpNewsCard(
    imageUrl: String, // Replace with actual image resource or URL
    title: String,
    date: String,
    source: String,
) {
    val imageModifier = Modifier
        .height(150.dp)
        .fillMaxWidth()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // First Row with two images
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            // Left Image
            Image(
                painter = rememberImagePainter(data = imageUrl),
                contentDescription = null,
                modifier = imageModifier
            )

            // Spacer between images
            Spacer(modifier = Modifier.width(16.dp))

            // Right Image
            Image(
                painter = rememberImagePainter(data = imageUrl), // Replace with another image resource or URL
                contentDescription = null,
                modifier = imageModifier
            )
        }

        // Spacer between image row and text
        Spacer(modifier = Modifier.height(16.dp))

        // Second Row with news title, source, and date
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            // Column for news title
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Spacer between news title and source
            Spacer(modifier = Modifier.width(16.dp))

            // Icon for news source
            Image(
                painter = painterResource(id = R.drawable.img_1), // Replace with actual source icon
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Bottom)
            )

            // Spacer between source and date
            Spacer(modifier = Modifier.width(4.dp))

            // Column for source and date
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = source,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray
                )
                Text(
                    text = date,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
fun StaggeredNewsListPreview() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(1) { _ ->
            DonaldTrumpNewsCard(
                imageUrl = (R.drawable.img_1).toInt().toString(),
                title = "Lorem Ipsum",
                date = "07-22-1995",
                source = "bbc"
            )
        }
    }
}
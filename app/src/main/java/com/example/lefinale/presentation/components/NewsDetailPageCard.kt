package com.example.lefinale.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Source
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lefinale.R
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailsPage() {
    val elevation = 8.dp
    val cardShape = RoundedCornerShape(corner = CornerSize(16.dp))



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // News Image Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .shadow(elevation, shape = cardShape)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = cardShape)
            ) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = cardShape),
                    contentScale = ContentScale.Crop
                )

                // Bottom-left icon for news source
                Icon(
                    imageVector = Icons.Default.Source,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomStart)
                )

                // Bottom-right text field for date
                Text(
                    text = "Nov 15, 2023",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomEnd),
                    fontSize = 12.sp // Adjust the font size as needed
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Second Card with title and content
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .shadow(elevation, shape = cardShape)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = cardShape)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Title
                    Text(
                        text = "News Title",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // Content
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                                "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Clickable text to open URL
//        Box(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//                // Align the Box
//                .clickable { openUrl(url = "https://www.example.com") }
//        ) {
//            Text(
//                text = "Read More",
//                modifier = Modifier.fillMaxWidth()
//                    .align(Alignment.BottomEnd)
//            )
//        }
    }
}




@Preview
@Composable
fun NewsDetailsPagePreview() {
    NewsDetailsPage()
}
package com.example.lefinale.presentation.components

import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.lefinale.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun AfricanNewsCard(
    imageUrl: String, // Replace with actual image resource or URL
    title: String,
    description: String,
    date: String,
    source: String,
    isLoading: Boolean = false
) {
    val cardShape = RoundedCornerShape(corner = CornerSize(16.dp))
    val elevation by animateFloatAsState(targetValue = if (isLoading) 0f else 8f)
    var rotationState by remember { mutableStateOf(0f) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(elevation = elevation.dp, shape = cardShape)
            .clip(cardShape)
    ) {
        val coroutineScope = rememberCoroutineScope()

        Column {
            // Placeholder with rounded edges and spinning animation
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                    .background(MaterialTheme.colorScheme.background)
                    .aspectRatio(1f)
                    .fillMaxWidth()
            ) {
                // Animated content or loading indicator can be added here
                if (!isLoading) {
                    val painter = rememberImagePainter(data = imageUrl)
                    val rotationModifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                        .graphicsLayer(rotationZ = rotationState)

                    Image(
                        painter = painter,
                        contentDescription = "News Image",
                        modifier = rotationModifier
                    )

                    val animatable = remember { Animatable(0f) }
                    LaunchedEffect(painter) {
                        animatable.animateTo(
                            targetValue = 360f,
                            animationSpec = infiniteRepeatable(
                                animation = tween(durationMillis = 3000),
                                repeatMode = RepeatMode.Restart
                            )
                        )
                    }

                    DisposableEffect(animatable) {
                        onDispose {
                            coroutineScope.launch {
                                animatable.stop()
                            }
                        }
                    }
                } else {
                    // Loading indicator or placeholder content
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.Center)
                    )
                }
            }

            // Text components
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Divider
            Divider(modifier = Modifier.fillMaxWidth())

            // Date and News Source at the bottom
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = date,
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontSize = 16.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Public,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Text(
                        text = source,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Black
                    )
                }
            }
        }
    }
}



//@Composable
//fun AfricanNewsCard(
//    imageUrl: String, // Replace with actual image resource or URL
//    title: String,
//    description: String,
//    date: String,
//    source: String,
//    isLoading: Boolean = false
//) {
//    val cardShape = RoundedCornerShape(corner = CornerSize(16.dp))
//    val elevation by animateFloatAsState(targetValue = if (isLoading) 0f else 8f)
//    val rotationState = remember { mutableStateOf(0f) }
//
//
//    val isRotating by rememberUpdatedState(isLoading)
//    Card(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
//            .shadow(elevation = elevation.dp, shape = cardShape)
//            .clip(cardShape)
//    ) {
//        val coroutineScope = rememberCoroutineScope()
//
//        Column {
//            // Placeholder with rounded edges and spinning animation
//            Box(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
//                    .background(MaterialTheme.colorScheme.background)
//                    .aspectRatio(1f)
//                    .fillMaxWidth()
//
//            ) {
//                // Animated content or loading indicator can be added here
//                if (!isLoading) {
//                    val painter = rememberImagePainter(data = imageUrl)
//                    Image(
//                        painter = painter,
//                        contentDescription = "News Image",
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
//                            .rotate(rotationState.value)
//                    )
//
//                    val targetRotation = remember { mutableStateOf(0f) }
//                    val rotationAnimation = animateFloatAsState(
//                        targetValue = targetRotation.value,
//                        animationSpec = tween(durationMillis = 500)
//                    )
//
//
//                    LaunchedEffect(painter) {
//                        coroutineScope.launch {
//                            while (true) {
//                                targetRotation.value = rotationState + 5f
//                                delay(16)
//                            }
//                        }
//                    }
//                } else {
//                    // Loading indicator or placeholder content
//                    CircularProgressIndicator(
//                        modifier = Modifier
//                            .size(48.dp)
//                            .align(Alignment.Center)
//                    )
//                }
//            }
//
//            // Text components
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth()
//            ) {
//                Text(
//                    text = title,
//                    style = MaterialTheme.typography.labelLarge,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.fillMaxWidth()
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Text(
//                    text = description,
//                    style = MaterialTheme.typography.bodyMedium,
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
//
//            // Divider
//            Divider(modifier = Modifier.fillMaxWidth())
//
//            // Date and News Source at the bottom
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(4.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.DateRange,
//                        contentDescription = null,
//                        tint = MaterialTheme.colorScheme.onBackground
//                    )
//                    Text(
//                        text = date,
//                        color = MaterialTheme.colorScheme.onTertiary,
//                        fontSize = 16.sp
//                    )
//                }
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(4.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Public,
//                        contentDescription = null,
//                        tint = Color.Black
//                    )
//                    Text(
//                        text = source,
//                        style = MaterialTheme.typography.labelSmall,
//                        color = Color.Black
//                    )
//                }
//            }
//        }
//    }
//}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview(showBackground = true)
fun AfricanNewsCardPreview() {
    AfricanNewsCard(
        imageUrl = "https://example.com/image.jpg",
        title = "Breaking News",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        date = "2 hours ago",
        source = "News Source"
    )
}
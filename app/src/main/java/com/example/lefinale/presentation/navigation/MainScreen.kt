package com.example.lefinale.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.data.model.repository.NewsRepository
import com.example.lefinale.presentation.screens.discover.DiscoverScreen
import com.example.lefinale.presentation.screens.home.NewsListScreen
import com.example.lefinale.presentation.screens.profile.ProfileScreen
import com.example.lefinale.presentation.viewmodels.NewsViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val targetScreen = rememberSaveable { mutableStateOf(Screens.NewsList) }

   // var viewModel = hiltViewModel<com.example.lefinale.presentation.viewmodels.NewsViewModel>()


    val items = listOf(
        Screens.NewsList,
        Screens.DiscoverPage,
        Screens.ProfileDetails
    )

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = targetScreen.value.header, color = Color.White
            )
        }, navigationIcon = {
            if (targetScreen.value.route == Screens.NewsDetails.route) {
                BackButton(navController = navController)
            }
        }, colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFF6F7FF7)))
    }, bottomBar = {
        BottomNavigation{
            BottomNavigation(
                backgroundColor = Color(0xFF6F7FF7)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(icon = {
                        Icon(
                            imageVector = if (screen.route == Screens.NewsList.route) {
                                                Icons.Filled.Home
                            } else if(screen.route == Screens.DiscoverPage.route) {
                                            Icons.Filled.Search
                            }else{
                                Icons.Filled.Person
                                 }, contentDescription = null,
                            tint = Color.White
                        )
                    },
                        label = { Text(screen.header, color = Color.White) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = false
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = false
                            }
                        })
                }
            }
        }
    }) {
        NavHost(
            navController = navController, startDestination = Screens.NewsList.route
        ) {
            composable(Screens.NewsList.route) {
                targetScreen.value = Screens.NewsList
               // val newsViewModel: NewsViewModel by viewModels()
                NewsListScreen(navController)
            }
//            composable("${Screens.MovieDetails.route}/{movieId}") { backStackEntry ->
//                targetScreen.value = Screens.MovieDetails
//                NewsDetailScreen(
//                    navController, backStackEntry.arguments?.getString("movieId")!!.toInt()
//                )
//            }
            composable(Screens.ProfileDetails.route) {
                targetScreen.value = Screens.ProfileDetails
                ProfileScreen(navController)
            }
            composable(Screens.DiscoverPage.route) {
                targetScreen.value = Screens.DiscoverPage
                DiscoverScreen(navController)
            }
        }
    }
}

@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White
        )
    }
}
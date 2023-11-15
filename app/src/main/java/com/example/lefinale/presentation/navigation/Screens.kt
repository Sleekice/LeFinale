package com.example.lefinale.presentation.navigation

import com.example.lefinale.presentation.navigation.ScreenName.NEWS_DETAILS
import com.example.lefinale.presentation.navigation.ScreenName.NEWS_DETAILS_HEADER
import com.example.lefinale.presentation.navigation.ScreenName.NEWS_DISCOVER
import com.example.lefinale.presentation.navigation.ScreenName.NEWS_DISCOVER_HEADER
import com.example.lefinale.presentation.navigation.ScreenName.NEWS_LIST
import com.example.lefinale.presentation.navigation.ScreenName.NEWS_LIST_HEADER
import com.example.lefinale.presentation.navigation.ScreenName.USER_PROFILE
import com.example.lefinale.presentation.navigation.ScreenName.USER_PROFILE_HEADER

enum class Screens(
    val route: String,
    val header: String
) {
    NewsList(route = NEWS_LIST, header = NEWS_LIST_HEADER),
    DiscoverPage(route = NEWS_DISCOVER, header = NEWS_DISCOVER_HEADER),
    ProfileDetails(route = USER_PROFILE, header = USER_PROFILE_HEADER),
    NewsDetails(route = NEWS_DETAILS, header = NEWS_DETAILS_HEADER)
}

object ScreenName {
    const val NEWS_LIST = "news_list"
    const val NEWS_LIST_HEADER = "News"


    const val NEWS_DISCOVER = "news_discover"
    const val NEWS_DISCOVER_HEADER = "Discover"

    const val USER_PROFILE = "favorite_list"
    const val USER_PROFILE_HEADER = "Profile"

    //Secondary pages outside the bottom Nav.
    const val NEWS_DETAILS = "news_details"
    const val NEWS_DETAILS_HEADER = "News Details"

}
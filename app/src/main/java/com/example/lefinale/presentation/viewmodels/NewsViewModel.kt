package com.example.lefinale.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.remote.africanews.AfricanNewsDataModel
import com.example.data.model.remote.africanews.ArticleModel
import com.example.data.model.remote.bbcnews.BBCNewsDataModel
import com.example.data.model.remote.businessinsider.BusinessInsiderDataModel
import com.example.data.model.remote.donaldtrumpnews.DonaldTrumpDataModel
import com.example.data.model.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    val newsRepository: NewsRepository
) : ViewModel() {



    private val _selectedArticle = MutableStateFlow<ArticleModel?>(null)
    val selectedArticle: StateFlow<ArticleModel?> = _selectedArticle
    // Function to set the selected article
    fun setSelectedArticle(article: ArticleModel) {
        _selectedArticle.value = article
    }

    // Function to clear the selected article
    fun clearSelectedArticle() {
        _selectedArticle.value = null
    }


    private val _bbcNewsData = MutableStateFlow<BBCNewsDataModel?>(null)
    val bbcNewsData: StateFlow<BBCNewsDataModel?> = _bbcNewsData

    private val _africanNewsData = MutableStateFlow<AfricanNewsDataModel?>(null)
    val africanNewsData: StateFlow<AfricanNewsDataModel?> = _africanNewsData

    private val _businessInsiderData = MutableStateFlow<BusinessInsiderDataModel?>(null)
    val businessInsiderData: StateFlow<BusinessInsiderDataModel?> = _businessInsiderData

    private val _donaldTrumpData = MutableStateFlow<DonaldTrumpDataModel?>(null)
    val donaldTrumpData: StateFlow<DonaldTrumpDataModel?> = _donaldTrumpData

    //Handle Circular Progress Indicator.
    private val _businessInsiderLoading = mutableStateOf(false)
    val businessInsiderLoading: State<Boolean> = _businessInsiderLoading





    fun getAllBBCNews(query: String) {
        viewModelScope.launch {
            try {
                val response = newsRepository.getAllBBCNews(query)
                if (response.isSuccessful) {
                    _bbcNewsData.value = response.body()
                } else {
                    // Handle error, you might want to throw an exception or handle it in some way
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }

    fun getAllAfricanNews(query: String) {
        viewModelScope.launch {
            try {
                val response = newsRepository.getAllAfricanNews(query)
                if (response.isSuccessful) {
                    _africanNewsData.value = response.body()
                } else {
                    // Handle error, you might want to throw an exception or handle it in some way
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }

    fun getAllBusinessInsiderNews(query: String) {

        _businessInsiderLoading.value = true


        viewModelScope.launch {
            try {
                val response = newsRepository.getAllBusinessInsiderNews(query)
                if (response.isSuccessful) {
                    _businessInsiderData.value = response.body()
                } else {
                    // Handle error, you might want to throw an exception or handle it in some way
                }
            } catch (e: Exception) {
                // Handle exception
            }
            finally {
                // Set loading state to false when data fetching is completed (either success or failure)
                _businessInsiderLoading.value = false
            }
        }
    }

    fun getAllDonaldTrumpNews(query: String) {
        viewModelScope.launch {
            try {
                val response = newsRepository.getAllDonaldTrumpNews(query)
                if (response.isSuccessful) {
                    _donaldTrumpData.value = response.body()
                } else {
                    // Handle error, you might want to throw an exception or handle it in some way
                }
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }


    //Detail Page ----->

}

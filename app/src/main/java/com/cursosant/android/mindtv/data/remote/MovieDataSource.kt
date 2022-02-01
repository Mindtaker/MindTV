package com.cursosant.android.mindtv.data.remote

import com.cursosant.android.mindtv.application.AppConstants
import com.cursosant.android.mindtv.data.model.MovieList
import com.cursosant.android.mindtv.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY, AppConstants.LANGUAGE)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY, AppConstants.LANGUAGE)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY, AppConstants.LANGUAGE)

}
package com.cursosant.android.mindtv.repository

import com.cursosant.android.mindtv.data.model.MovieList

interface MovieRepository {
    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}
package com.cursosant.android.mindtv.repository

import com.cursosant.android.mindtv.data.model.MovieList
import com.cursosant.android.mindtv.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {
    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}
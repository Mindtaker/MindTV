package com.cursosant.android.mindtv.repository

import com.cursosant.android.mindtv.application.AppConstants
import com.cursosant.android.mindtv.data.model.MovieList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query ("api_key") apiKey: String, @Query ("language") language: String): MovieList

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query ("api_key") apiKey: String, @Query ("language") language: String): MovieList

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query ("api_key") apiKey: String, @Query ("language") language: String): MovieList
}

object RetrofitClient {
    val webservice by lazy { //cuando llamemos a retrofit inicia la variable cuando llame al webservice, no antes
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())) //para convertir el JSON al objeto Movie
            .build().create(WebService::class.java)
    }
}
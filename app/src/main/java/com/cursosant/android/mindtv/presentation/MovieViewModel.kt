package com.cursosant.android.mindtv.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.cursosant.android.mindtv.core.Resource
import com.cursosant.android.mindtv.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MovieViewModel(private val repo: MovieRepository ): ViewModel() { //Instancias de VM deben ser vacias

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())

        try {
            //emit(Resource.Success(repo.getUpcomingMovies()))
            emit(Resource.Success(Triple(repo.getUpcomingMovies(),repo.getTopRatedMovies(),repo.getPopularMovies())))
        }catch (e: Exception) {
            emit(Resource.Failure(e))
        }

    }
}

class MovieViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}
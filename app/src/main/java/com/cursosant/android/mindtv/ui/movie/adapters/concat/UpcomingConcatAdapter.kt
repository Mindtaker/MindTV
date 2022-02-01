package com.cursosant.android.mindtv.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cursosant.android.mindtv.core.BaseConcatHolder
import com.cursosant.android.mindtv.databinding.UpcomingMoviesRowBinding
import com.cursosant.android.mindtv.ui.movie.adapters.MovieAdapter

class UpcomingConcatAdapter (private val moviesAdapter: MovieAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = UpcomingMoviesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1 //Ya que le paso solo un adaptador

    private inner class ConcatViewHolder(val binding: UpcomingMoviesRowBinding): BaseConcatHolder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter) {
            binding.rvUpcomingMovies.adapter = adapter
        }

    }
}
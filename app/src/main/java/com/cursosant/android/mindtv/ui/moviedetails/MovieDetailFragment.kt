package com.cursosant.android.mindtv.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.cursosant.android.mindtv.R
import com.cursosant.android.mindtv.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)

        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.posterImageUrl}")
            .centerCrop().into(binding.imgMovie)
        Glide.with(requireContext())
            .load("https://image.tmdb.org/t/p/w500/${args.backgroundImageUrl}").centerCrop()
            .into(binding.imgBackground)
        binding.txtDescription.text = args.overview
        binding.txtMovieTitle.text = args.title
        binding.txtLanguage.text = "Idioma original: ${args.language}"
        binding.txtRating.text = "${args.voteAverage} (${args.voteCount} valoraciones)"
        binding.txtRelease.text = "Lanzada el  ${args.releaseDate}"
    }

}
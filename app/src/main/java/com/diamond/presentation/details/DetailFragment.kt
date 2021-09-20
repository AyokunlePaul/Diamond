package com.diamond.presentation.details

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.diamond.R
import com.diamond.databinding.FragmentDetailBinding
import com.diamond.presentation.details.DetailFragmentViewModel.MovieDetailResult.Successful
import com.diamond.utils.BaseFragment
import com.diamond.utils.DiamondImageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val viewModel by viewModels<DetailFragmentViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenResumed {
            viewModel.movieDetail.collect { result ->
                when (result) {
                    is Successful -> {
                        val movieDetail = result.data
                        with(binding) {
                            tvMovieTitle.text = movieDetail.title
                            tvOverview.text = movieDetail.overview
                            tvHomepage.text = HtmlCompat.fromHtml(getString(R.string.homepage, movieDetail.homepage), FROM_HTML_MODE_LEGACY)
                            tvOriginalTitle.text =
                                getString(R.string.original_title, movieDetail.originalTitle)
                            tvOriginalTitle.text =
                                getString(R.string.original_language, movieDetail.originalLanguage)
                            tvPopularity.text =
                                getString(R.string.popularity, movieDetail.popularity.toString())
                            tvBudget.text = getString(R.string.budget, movieDetail.budget)
                            tvReleaseDate.text =
                                getString(R.string.release_date, movieDetail.releaseDate)
                            tvRevenue.text = getString(R.string.revenue, movieDetail.revenue)
                            tvRuntime.text = getString(R.string.runtime, movieDetail.runtime)
                            tvVoteCount.text = getString(R.string.vote_count, movieDetail.voteCount)
                            tvVoteAverage.text =
                                getString(R.string.vote_average, movieDetail.voteAverage.toString())
                            DiamondImageLoader.loadImage(movieDetail.posterPath, imgPosterPath)
                            imgAdult.isEnabled = movieDetail.adult
                        }
                    }
                }
            }
        }
        viewModel.getMovieDetail(args.movieId)
    }
}
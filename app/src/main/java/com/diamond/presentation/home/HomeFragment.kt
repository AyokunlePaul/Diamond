package com.diamond.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.diamond.R
import com.diamond.databinding.FragmentHomeBinding
import com.diamond.model.DiscoverMovieModel
import com.diamond.presentation.home.HomeFragmentViewModel.DiscoveredMovies.Success
import com.diamond.presentation.home.adapter.DiscoverMovieAdapter
import com.diamond.utils.BaseFragment
import com.diamond.utils.RecyclerInsetsDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), (DiscoverMovieModel) -> Unit {

    private val viewModel by viewModels<HomeFragmentViewModel>()
    private val discoverMovieAdapter = DiscoverMovieAdapter(this)

    override fun setupBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            rvDiscoveredMovies.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = discoverMovieAdapter
                if (itemDecorationCount == 0) {
                    val inset = resources.getDimension(R.dimen.discover_movies_card_inset).toInt()
                    addItemDecoration(RecyclerInsetsDecoration(inset))
                }
            }
        }
        lifecycleScope.launchWhenResumed {
            viewModel.movies.collect {
                when (it) {
                    is Success -> discoverMovieAdapter.setMovieData(it.data, false)
                }
            }
        }
    }

    override fun invoke(movie: DiscoverMovieModel) {
        val direction = HomeFragmentDirections.actionFragmentHomeToFragmentDetail(movie.id)
        findNavController().navigate(direction)
    }
}
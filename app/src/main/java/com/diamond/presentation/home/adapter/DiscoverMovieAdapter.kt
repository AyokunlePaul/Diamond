package com.diamond.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.diamond.model.DiscoverMovieModel
import com.diamond.presentation.home.adapter.viewholder.DiscoverMovieViewHolder
import com.diamond.utils.AutoUpdateRecyclerView
import kotlin.properties.Delegates

class DiscoverMovieAdapter(
    private val onClick: (DiscoverMovieModel) -> Unit
) : Adapter<DiscoverMovieViewHolder>(), AutoUpdateRecyclerView {

    private var movies: List<DiscoverMovieModel> by Delegates.observable(emptyList()) { _, oldMovies, newMovies ->
        autoNotify(oldMovies, newMovies) { oldMovie, newMovie ->
            oldMovie.id == newMovie.id
        }
    }
    private var _inflater: LayoutInflater? = null
    private val inflater: LayoutInflater get() = _inflater!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverMovieViewHolder {
        if (_inflater == null) {
            _inflater = LayoutInflater.from(parent.context)
        }
        return DiscoverMovieViewHolder.new(inflater, parent, onClick)
    }

    override fun onBindViewHolder(holder: DiscoverMovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun setMovieData(data: List<DiscoverMovieModel>, isFirstTime: Boolean = false) {
        movies = if (isFirstTime) data else movies + data
    }
}
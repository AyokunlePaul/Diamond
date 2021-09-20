package com.diamond.presentation.home.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.diamond.databinding.ItemMovieBinding
import com.diamond.model.DiscoverMovieModel
import com.diamond.utils.DiamondImageLoader

class DiscoverMovieViewHolder private constructor(
    private val binding: ItemMovieBinding,
    private val onClick: (DiscoverMovieModel) -> Unit
) : ViewHolder(binding.root) {

    fun bind(data: DiscoverMovieModel) {
        with(binding) {
            tvMovieTitle.text = data.title
            tvMovieDescription.text = data.description
            root.setOnClickListener { onClick.invoke(data) }
            DiamondImageLoader.loadImage(data.movieIcon, imgMovie)
        }
    }

    companion object {
        @JvmStatic
        fun new(
            inflater: LayoutInflater,
            parent: ViewGroup?,
            onClick: (DiscoverMovieModel) -> Unit
        ): DiscoverMovieViewHolder {
            val binding = ItemMovieBinding.inflate(inflater, parent, false)
            return DiscoverMovieViewHolder(binding, onClick)
        }
    }
}
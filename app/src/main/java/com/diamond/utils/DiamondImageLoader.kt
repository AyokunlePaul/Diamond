package com.diamond.utils

import android.widget.ImageView
import coil.load
import coil.size.Scale.FILL
import com.diamond.BuildConfig

object DiamondImageLoader {

    @JvmStatic
    fun loadImage(posterPath: String, imageView: ImageView) {
        imageView.load("${BuildConfig.IMAGE_URL}$posterPath") {
            crossfade(true)
            scale(FILL)
        }
    }
}
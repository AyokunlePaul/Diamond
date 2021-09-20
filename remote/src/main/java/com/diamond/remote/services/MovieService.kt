package com.diamond.remote.services

import com.diamond.remote.model.BasePagedModel
import com.diamond.remote.model.discover.DiscoverMovieRemoteModel
import com.diamond.remote.model.movie.MovieDetailRemoteModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MovieService {

    @GET("discover/movie")
    suspend fun discoverMovies(@QueryMap queries: HashMap<String, Any>): BasePagedModel<List<DiscoverMovieRemoteModel>>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @QueryMap queries: HashMap<String, Any>
    ): MovieDetailRemoteModel
}
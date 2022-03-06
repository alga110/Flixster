package com.example.flixster

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import org.json.JSONArray
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val voteAverage: Double,
    val id: Int,
    private val posterPath: String,
    val overview: String,
) : Parcelable {

    @IgnoredOnParcel
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"

    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        title = movieJson.getString("title"),
                        voteAverage = movieJson.getDouble("vote_average"),
                        id = movieJson.getInt("id"),
                        posterPath = movieJson.getString("poster_path"),
                        overview = movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}
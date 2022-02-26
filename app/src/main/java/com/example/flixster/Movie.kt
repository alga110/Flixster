package com.example.flixster

import org.json.JSONArray

data class Movie(
    val title: String,
    val id: Int,
    private val posterPath: String,
    val overview: String,
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        title = movieJson.getString("title"),
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
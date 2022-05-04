package com.strv.movies.ui.movieslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.strv.movies.R
import com.strv.movies.data.OfflineMoviesProvider
import com.strv.movies.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
            contentDescription = stringResource(id = R.string.movie_image)
        )

        Text(text = movie.title, textAlign = TextAlign.Center)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesList(movies: List<Movie>) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        modifier = Modifier.padding(horizontal = 14.dp)
    ) {
        items(movies) { movie ->
            MovieItem(movie)
        }
    }
}

@Preview
@Composable
fun MoviesListPreview() {
    MoviesList(movies = OfflineMoviesProvider.getMovies())
}
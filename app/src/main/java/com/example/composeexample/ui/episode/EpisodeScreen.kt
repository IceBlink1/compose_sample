package com.example.composeexample.ui.episode

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.domain.model.Episode

@Composable
fun EpisodeScreen(uiState: EpisodeUiState.Loading) {
    Text(text = "Loading, plz w8")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EpisodeScreen(uiState: EpisodeUiState.Content) {
    val pagingItems = uiState.pagedData.collectAsLazyPagingItems()
    LazyColumn(
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
    ) {
        items(pagingItems.itemCount) { index ->
            pagingItems[index]?.let { EpisodeItem(episode = it, modifier = Modifier) }
        }
    }


}


@Composable
fun EpisodeItem(episode: Episode, modifier: Modifier) {

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        elevation = 4.dp,
    ) {

        Column(
            modifier = modifier.padding(
                top = 8.dp, bottom = 16.dp,
                start = 16.dp, end = 16.dp
            )
        ) {
            Text(
                text = episode.name,
                style = MaterialTheme.typography.h5,
                overflow = TextOverflow.Ellipsis
            )
            Text(text = "Air Date: ${episode.airDate}", style = MaterialTheme.typography.body1)
            Text(text = "Episode: ${episode.episode}", style = MaterialTheme.typography.body1)
        }
    }

}
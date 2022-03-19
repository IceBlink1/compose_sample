package com.example.composeexample.ui.character

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.domain.model.Character

@Composable
fun CharacterScreen(uiState: CharacterUiState.Loading) {
    Text(text = "Loading, plz w8")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterScreen(uiState: CharacterUiState.Content) {
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
            pagingItems[index]?.let { CharacterItem(character = it, modifier = Modifier) }
        }
    }


}


@Composable
fun CharacterItem(character: Character, modifier: Modifier) {

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        elevation = 4.dp,
    ) {
        Row(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {
            AsyncImage(
                model = character.image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxHeight()
            )
            Column(
                modifier = modifier.padding(
                    top = 8.dp, bottom = 16.dp,
                    start = 16.dp, end = 16.dp
                )
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h5,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = "Status: ${character.status}", style = MaterialTheme.typography.body1)
                Text(text = "Gender: ${character.gender}", style = MaterialTheme.typography.body1)
                Text(
                    text = "Origin: ${character.originName}",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Location: ${character.locationName}",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Species: ${character.species}", style = MaterialTheme.typography.body2
                )
            }
        }
    }

}
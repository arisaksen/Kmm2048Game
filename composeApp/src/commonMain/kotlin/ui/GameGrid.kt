package ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.Tile


@Composable
fun GameGrid(gridTiles: MutableList<Tile>) {
    Surface(modifier = Modifier.padding(20.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .border(BorderStroke(5.dp, Color.LightGray))
                .background(Color.LightGray),
            contentPadding = PaddingValues(5.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            itemsIndexed(gridTiles) { index, item ->
                GameTile(
                    tile = item,
                    modifier = Modifier.aspectRatio(1f)
                )
            }
        }
    }
}
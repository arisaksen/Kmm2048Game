package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GameTopHeader(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "2048",
                        style = MaterialTheme.typography.h2,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                    Card {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Score", style = MaterialTheme.typography.h5)
                            Text(text = "666", style = MaterialTheme.typography.h6)
                        }
                    }
                    Card {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Best", style = MaterialTheme.typography.h5)
                            Text(text = "666", style = MaterialTheme.typography.h6)
                        }
                    }

                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(end = 15.dp),
                    horizontalArrangement = Arrangement.End,
                ) {
                    GameButton(text = "New Game", onClick = {})
                }
            }
        }
    }

}

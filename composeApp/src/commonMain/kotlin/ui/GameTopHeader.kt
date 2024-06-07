package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun GameTopHeader(
    score: Int,
    topScore: Int,
    newGameClick: () -> Unit = {},
    gameUpdateClick: () -> Unit = {}
) {
    val colorState = mutableStateOf(Color.Red)

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
                            Text(text = "$score", style = MaterialTheme.typography.h6)
                        }
                    }
                    Card {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Best", style = MaterialTheme.typography.h5)
                            Text(text = "$topScore", style = MaterialTheme.typography.h6)
                        }
                    }

                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(end = 15.dp),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Box(
                        modifier = Modifier.size(50.dp)
                            .background(colorState.value)
                            .clickable {
                                colorState.value = Color(
                                    Random.nextFloat(),
                                    Random.nextFloat(),
                                    Random.nextFloat(),
                                    1f
                                )
                                gameUpdateClick()
                            },
                    )
                    GameButton(text = "New Game", onClick = { newGameClick() })
                }
                Text(
                    modifier = Modifier.padding(top = 5.dp).fillMaxWidth(),
                    text = "Join the numbers and get to the 2048 tile!",
                    textAlign = TextAlign.Center,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
        }
    }

}

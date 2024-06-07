import data.Tile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Used to create a click delay in buttons */
fun debounce(
    waitMs: Long = 300L,
    coroutineContext: CoroutineContext,
    action: () -> Unit
): () -> Unit {
    var job: Job? = null
    return {
        job?.cancel()
        job = CoroutineScope(coroutineContext).launch {
            delay(waitMs)
            action()
        }
    }
}

fun recreateGrid(gridSize: Int = 4): MutableList<Tile> {
    val startNumbers = listOf(0, 2)
    val startGrid = mutableListOf<Tile>()
    for (col in 1..gridSize) {
        for (row in 1..gridSize) {
            val startNumber = startNumbers.random()
            startGrid.add(Tile(num = startNumber))
        }
    }
    return startGrid
}

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.input.pointer.PointerInputScope
import data.Tile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.math.abs

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

fun recreateGrid(gridSize: Int = 4, startNumbers: List<Int> = listOf(0, 2)): MutableList<Tile> {
    val startGrid = mutableListOf<Tile>()
    for (col in 1..gridSize) {
        for (row in 1..gridSize) {
            val startNumber = startNumbers.random()
            startGrid.add(Tile(num = startNumber))
        }
    }
    return startGrid
}

suspend fun PointerInputScope.detectSwipe(
    swipeState: MutableIntState = mutableIntStateOf(-1),
    onSwipeLeft: () -> Unit = {},
    onSwipeRight: () -> Unit = {},
    onSwipeUp: () -> Unit = {},
    onSwipeDown: () -> Unit = {},
) = detectDragGestures(
    onDrag = { change, dragAmount ->
        change.consume()
        val (x, y) = dragAmount
        if (abs(x) > abs(y)) {
            when {
                x > 0 -> swipeState.intValue = 0
                x < 0 -> swipeState.intValue = 1
            }
        } else {
            when {
                y > 0 -> swipeState.intValue = 2
                y < 0 -> swipeState.intValue = 3
            }
        }
    },
    onDragEnd = {
        when (swipeState.intValue) {
            0 -> onSwipeRight()
            1 -> onSwipeLeft()
            2 -> onSwipeDown()
            3 -> onSwipeUp()
        }
    }
)

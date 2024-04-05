package com.ptut.sideeffecttest.produce_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

/**
 * purpose of this function to produce some kind of state changes over time
 * use produceState instead of Flow collection
 */
@Composable
fun produceStateDemo(countUpTo: Int): State<Int> {

    return produceState(initialValue = 0) {
        // in here called suspend function
        while (value < countUpTo) {
            delay(1.seconds)
            value++
        }
    }
}
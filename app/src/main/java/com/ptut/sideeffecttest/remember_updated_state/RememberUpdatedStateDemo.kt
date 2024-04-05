package com.ptut.sideeffecttest.remember_updated_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

/**
 * set key to true is only once will do in LaunchedEffect
 * issue is that it will not trigger LaunchedEffect again (use rememberUpdateState)
 */
@Composable
fun RememberUpdatedStateDemo(
    onTimeout: () -> Unit
) {
    // set key to true is only once will do in LaunchedEffect
    // issue is that it will not trigger LaunchedEffect again (use rememberUpdateState)
    LaunchedEffect(key1 = true) {
        delay(3.seconds)
        onTimeout()
    }

    // Right Answer
    val updatedOnTimeOut by rememberUpdatedState(newValue = onTimeout)
    LaunchedEffect(key1 = true) {
        delay(3.seconds)
        updatedOnTimeOut()
    }
}
package com.ptut.sideeffecttest.remember_coroutine_scope

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

/**
 * use rememberCoroutineScope only in callback
 */
@Composable
fun RememberCoroutineScopeDemo(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    Button(
        modifier = modifier,
        onClick = {
            scope.launch {
                delay(1.seconds)
                println("Hello World!")
            }
        }
    ) {

    }
}
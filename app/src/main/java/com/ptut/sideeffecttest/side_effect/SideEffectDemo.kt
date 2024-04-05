package com.ptut.sideeffecttest.side_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

/**
 * called whenever ur composable successfully recomposable
 * use case: logging, analytics, etc
 */
@Composable
fun SideEffectDemo(nonComposeCounter: Int, ) {
    SideEffect {
        println("Hello World!")
    }
}
package com.ptut.sideeffecttest.snapshot_flow

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull

/**
 * snapshotFlow is a flow that emits the current value of the given state object and then
 */
@Composable
fun SnapshotFlowDemo() {
    val scaffoldState = SnackbarHostState()
    LaunchedEffect(key1 = scaffoldState) {
        snapshotFlow { scaffoldState }
            .mapNotNull { it.currentSnackbarData?.visuals?.message }
            .distinctUntilChanged()
            .collect { message ->
                println("snackbar with message: $message")
            }
    }
}
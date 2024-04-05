package com.ptut.sideeffecttest.derived_state_of

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * use especially and computation heavy recomposition
 * whenever counter updated counterText will be recomputed and recompose
 * prevent recomputation of counterText by using derivedStateOf
 */
@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableIntStateOf(0)
    }
    val counterText by remember(counter) {
        derivedStateOf {
            "Counter: $counter"
        }
    }
    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}
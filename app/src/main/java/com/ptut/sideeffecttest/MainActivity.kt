package com.ptut.sideeffecttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ptut.sideeffecttest.ui.theme.SideEffectTestTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            SideEffectTestTheme {
                // whenever the text changes, the LaunchedEffect will be triggered and launch a coroutine
                LaunchedEffect(key1 = text) {
                    delay(1.seconds)
                    println("text: $text")
                }

                Button(onClick = { text += "#" }) {
                    i++
                    Text(text = text)
                }
            }
        }
    }
}

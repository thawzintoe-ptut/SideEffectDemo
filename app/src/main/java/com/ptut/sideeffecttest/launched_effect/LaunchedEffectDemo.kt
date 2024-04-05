package com.ptut.sideeffecttest.launched_effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun LaunchedEffectFlowDemo(viewModel: LaunchedEffectViewModel) {
    LaunchedEffect(key1 = true) {
        viewModel.sharedFlow.collect { event ->
            when (event) {
                is LaunchedEffectViewModel.ScreenEvents.ShowToast -> {
                    // show toast
                }
                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {
                    // navigate
                }
            }
        }
    }
}
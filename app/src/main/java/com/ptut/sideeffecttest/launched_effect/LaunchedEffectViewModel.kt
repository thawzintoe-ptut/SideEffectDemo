package com.ptut.sideeffecttest.launched_effect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchedEffectViewModel: ViewModel() {
    private val _sharedFlow = MutableSharedFlow<ScreenEvents>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _sharedFlow.emit(ScreenEvents.ShowToast("Hello World!"))
        }
    }

    sealed interface ScreenEvents {
        data class ShowToast(val message: String): ScreenEvents
        data class Navigate(val route: String): ScreenEvents
    }
}
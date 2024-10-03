package modulo_05.sprint.retrofit_one.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class DisneyViewModel(
    private val repository: DisneyRepository= DisneyRepository(DisneyApi.instance)
): ViewModel() {
    var state by mutableStateOf(MainState())
       private set
    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.getCharacters().onSuccess {
                state = state.copy(characters = it)
                println()
            }.onFailure {
                println()

            }
            state = state.copy(isLoading = false)
        }
    }
}


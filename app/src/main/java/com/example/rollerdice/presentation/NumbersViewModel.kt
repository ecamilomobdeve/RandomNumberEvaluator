package com.example.rollerdice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rollerdice.data.NumberRepository
import com.example.rollerdice.domain.models.NumberPair
import com.example.rollerdice.domain.usecase.EvaluateSumUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class UIState(
    val numberPair: NumberPair = NumberPair(0, 0),
    val message: String = ""
)

class NumbersViewModel(
    private val repository: NumberRepository,
    private val useCase: EvaluateSumUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState

    init {
        viewModelScope.launch {
            repository.generateNumbers().collect { pair ->
                val message = useCase.evaluate(pair)
                _uiState.value = UIState(pair, message)
            }
        }
    }
}

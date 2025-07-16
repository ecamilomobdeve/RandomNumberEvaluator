package com.example.rollerdice.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rollerdice.data.NumberRepository
import com.example.rollerdice.domain.usecase.EvaluateSumUseCase

class NumbersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NumbersViewModel(
            NumberRepository(),
            EvaluateSumUseCase()
        ) as T
    }
}

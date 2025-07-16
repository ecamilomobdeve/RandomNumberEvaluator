package com.example.rollerdice.domain.usecase

import com.example.rollerdice.domain.models.NumberPair

class EvaluateSumUseCase {
    fun evaluate(pair: NumberPair): String {
        val sum = pair.first + pair.second
        return when {
            sum > 100 -> "I cannot evaluate numbers in which sum is greater than 100"
            sum % 2 == 0 -> "The sum is even"
            else -> "The sum is odd"
        }
    }
}
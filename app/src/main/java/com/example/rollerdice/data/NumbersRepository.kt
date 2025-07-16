package com.example.rollerdice.data

import com.example.rollerdice.domain.models.NumberPair
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class NumberRepository {
    fun generateNumbers(): Flow<NumberPair> = flow {
        while (true) {
            val first = Random.nextInt(1, 80)
            val second = Random.nextInt(1, 80)
            emit(NumberPair(first, second))
            delay(2000)
        }
    }
}
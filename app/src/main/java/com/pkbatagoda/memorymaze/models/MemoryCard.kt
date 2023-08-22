package com.pkbatagoda.memorymaze.models

data class MemoryCard (
    val identifier: Int,
    val isFaceUp: Boolean = false,
    val isMatched: Boolean = false
        )
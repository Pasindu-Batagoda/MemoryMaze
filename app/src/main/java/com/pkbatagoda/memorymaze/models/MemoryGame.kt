package com.pkbatagoda.memorymaze.models

import com.pkbatagoda.memorymaze.utils.DEFAULT_ICONS

class MemoryGame (private val boardSize: BoardSize){
    val cards: List<MemoryCard>
    val numPairsFound = 0

    init {
        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()
   cards =  randomizedImages.map { MemoryCard(it) }
    }
}
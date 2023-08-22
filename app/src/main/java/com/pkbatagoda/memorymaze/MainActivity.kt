package com.pkbatagoda.memorymaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pkbatagoda.memorymaze.models.BoardSize
import com.pkbatagoda.memorymaze.models.MemoryCard
import com.pkbatagoda.memorymaze.models.MemoryGame
import com.pkbatagoda.memorymaze.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "mainActivity"
    }

    // referencing widgets in layout
    private lateinit var rvBoard : RecyclerView
    private lateinit var tvNumMoves : TextView
    private lateinit var tvNumPairs : TextView

    private var boardSize: BoardSize = BoardSize.HARD
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set the newly defined variables equal to the corresponding view in the layout
        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

       val memoryGame = MemoryGame(boardSize)

        rvBoard.adapter = MemoryBoardAdapter(this, boardSize, memoryGame.cards, object: MemoryBoardAdapter.CardClickListener {
            override fun onCardClicked(position: Int) {
                Log.i(TAG, "Card clicked $position")
            }

        })

        rvBoard.setHasFixedSize(true)
        // spanCount - number of columns in the Recycler view
        rvBoard.layoutManager = GridLayoutManager (this , boardSize.getWidth())


    }
}
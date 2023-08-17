package com.pkbatagoda.memorymaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pkbatagoda.memorymaze.models.BoardSize

class MainActivity : AppCompatActivity() {

    // referencing widgets in layout
    private lateinit var rvBoard : RecyclerView
    private lateinit var tvNumMoves : TextView
    private lateinit var tvNumPairs : TextView

    private var boardSize: BoardSize = BoardSize.EASY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set the newly defined variables equal to the corresponding view in the layout
        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        rvBoard.adapter = MemoryBoardAdapter(this, boardSize)

        rvBoard.setHasFixedSize(true)
        // spanCount - number of columns in the Recycler view
        rvBoard.layoutManager = GridLayoutManager (this , boardSize.getWidth())


    }
}
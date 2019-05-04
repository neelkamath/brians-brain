package com.neelkamath.briansbrain

typealias Board = List<List<State>>

/** The state of a cell in a [Board]. */
enum class State(val value: Int) {
    OFF(0), DYING(1), ON(2)
}

/** Generates grids of size [rows] and [columns] for the Brian's Brain cellular automaton. */
class BriansBrain(private val rows: Int, private val columns: Int) {
    private val board = List(rows) {
        MutableList(columns) { listOf(State.OFF, State.ON).random() }
    }

    private fun northWestIsOn(row: Int, column: Int) =
            if (row == 0 || column == 0) false else board[row - 1][column - 1] == State.ON

    private fun northIsOn(row: Int, column: Int) = if (row == 0) false else board[row - 1][column] == State.ON

    private fun northEastIsOn(row: Int, column: Int) =
            if (row == 0 || column == columns - 1) false else board[row - 1][column + 1] == State.ON

    private fun westIsOn(row: Int, column: Int) = if (column == 0) false else board[row][column - 1] == State.ON

    private fun eastIsOn(row: Int, column: Int) =
            if (column == columns - 1) false else board[row][column + 1] == State.ON

    private fun southWestIsOn(row: Int, column: Int) =
            if (row == rows - 1 || column == 0) false else board[row + 1][column - 1] == State.ON

    private fun southIsOn(row: Int, column: Int) = if (row == rows - 1) false else board[row + 1][column] == State.ON

    private fun southEastIsOn(row: Int, column: Int) =
            if (row == rows - 1 || column == columns - 1) false else board[row + 1][column + 1] == State.ON

    private fun hasTwoNeighborsOn(row: Int, column: Int): Boolean {
        var onNeighbors = 0
        if (northWestIsOn(row, column)) {
            onNeighbors++
        }
        if (northIsOn(row, column)) {
            onNeighbors++
        }
        if (northEastIsOn(row, column)) {
            onNeighbors++
        }
        if (westIsOn(row, column)) {
            onNeighbors++
        }
        if (eastIsOn(row, column)) {
            onNeighbors++
        }
        if (southWestIsOn(row, column)) {
            onNeighbors++
        }
        if (southIsOn(row, column)) {
            onNeighbors++
        }
        if (southEastIsOn(row, column)) {
            onNeighbors++
        }
        return onNeighbors == 2
    }

    /** Returns the [Board] at the next time step. */
    fun getGrid(): Board {
        for ((rowIndex, row) in board.withIndex()) {
            for ((columnIndex, column) in row.withIndex()) {
                row[columnIndex] = when (column) {
                    State.ON -> State.DYING
                    State.DYING -> State.OFF
                    State.OFF -> if (hasTwoNeighborsOn(rowIndex, columnIndex)) State.ON else column
                }
            }
        }
        return board
    }
}

/** Returns a [String] for pretty printing a [Board]. */
fun prettifyGrid(board: Board): String {
    var grid = ""
    for (row in board) {
        grid += row.joinToString(" ", postfix = "\n") { it.value.toString() }
    }
    return grid
}

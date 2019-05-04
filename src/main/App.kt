package com.neelkamath.briansbrain

fun main(args: Array<String>) {
    val (rows, columns, steps) = args.map { it.toInt() }
    val brain = BriansBrain(rows, columns)
    repeat(steps) { println("Time step: $it\n${prettifyGrid(brain.getGrid())}") }
}

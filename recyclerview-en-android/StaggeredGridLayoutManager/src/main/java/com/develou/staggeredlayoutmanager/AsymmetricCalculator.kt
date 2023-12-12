package com.develou.staggeredlayoutmanager

object AsymmetricCalculator {

    fun isDoubleHeightPosition(position: Int): Boolean {
        val distanceLeftToRight = 4
        val distanceRightToLeft = 2
        val positions = generateSequence(Pair(0, distanceLeftToRight)) {
            val newFirst = it.second + distanceRightToLeft
            val newSecond = newFirst + distanceLeftToRight
            Pair(newFirst, newSecond)
        }
        return positions.flatMap { it.toList() }.take(7).any { it == position }
    }
}
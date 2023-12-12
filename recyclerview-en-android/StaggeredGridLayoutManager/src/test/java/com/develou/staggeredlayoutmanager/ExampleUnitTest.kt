package com.develou.staggeredlayoutmanager

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val distanceLeftToRight = 4
        val distanceRightToLeft = 2
        val s = generateSequence(Pair(0, distanceLeftToRight)) {
            val newFirst = it.second + distanceRightToLeft
            val newSecond = newFirst + distanceLeftToRight
            Pair(newFirst, newSecond)
        }
        print(s.flatMap { it.toList() }.take(7).toList())
        // 0, 4, 6, 10, 12, 16
        // 0, ni, (n+1)i, 2ni, (2n+1)i
    }

}
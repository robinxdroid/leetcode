package com.github.leetcode

import com.github.leetcode.array.Introduction
import com.github.leetcode.array.MatrixIntroduction

/**
 * @author wangbin@huami.com <br></br>
 * @since 2021/1/26
 */
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val temp = intArrayOf(-1, -1, -1, -1, -1, 0)
        val result = Introduction.findMiddleIndex(temp)
        println(result)

        val searchResult = Introduction.searchInsert(intArrayOf(1, 3, 5, 6), 5)
        println(searchResult)

        //Matrix
        val intervals =
            arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        val mergerResult = MatrixIntroduction.mergeArray(intervals)
        mergerResult.forEach {
            println("mergerResult：${it.contentToString()}")
        }

        val matrix = arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(2, 6, 7, 8),
            intArrayOf(8, 10, 12, 14),
            intArrayOf(15, 18, 19, 20)
        )
        matrix.forEach {
            println("旋转前matrix:${it.contentToString()}")
        }
        MatrixIntroduction.rotate(matrix)
        matrix.forEach {
            println("旋转后matrix:${it.contentToString()}")
        }

        val matrix2 = arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(2, 6, 0, 8),
            intArrayOf(8, 10, 12, 14),
            intArrayOf(15, 18, 19, 20)
        )
        matrix2.forEach {
            println("零矩阵前matrix:${it.contentToString()}")
        }
        MatrixIntroduction.setZeroes(matrix2)
        matrix2.forEach {
            println("零矩阵后matrix:${it.contentToString()}")
        }
    }
}
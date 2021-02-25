package com.github.leetcode.array

import java.util.*

/**
 * 二维数组简介
 * @author wangbin@huami.com <br></br>
 * @since 2021/1/26
 */
object MatrixIntroduction {
    /**
     * 合并区间
     * 思路：
    1.先对输入数组按照区间左边的值进行升序排列
    2.初始化一个变量 outputs，用于存储合并直接的区间结果
    3.遍历排序后的所有区间，针对每个区间做如下的处理：
    1.如果当前处理的区间是第一个区间的话，那么直接将区间加入到 outputs
    2.比较当前处理区间左边的值 (currLeft) 和 outputs 中最后一个区间右边的值 (outputsLastRight) ：
    1.如果 outputsLastRight < currLeft，说明没有重叠，那么直接将当前处理的区间加入到 outputs
    2.否则，说明有重叠，那么将 outputs 中最后一个区间的右边的值更新为：当前处理区间右边值和 outputsLastRight 的最大值
    4.将 outputs 转成数组，并返回
     * @param intervals
     * @return
     */
    fun mergeArray(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val outputs = mutableListOf<IntArray>()
        outputs.add(intervals.first())
        run loop@{
            intervals.forEach { ints ->
                val outputsLast = outputs.last()
                if (outputsLast[1] < ints[1] && outputsLast[1] < ints[0]) {
                    outputs.add(ints)
                } else if (outputsLast[1] < ints[1]) {
                    outputs.last()[1] = ints[1]
                }
            }
        }
        return outputs.toTypedArray()
    }

    /**
     * N × N矩阵顺时针旋转90度
     * 规律：对于矩阵中第 ii 行的第 jj 个元素，在旋转后，它出现在倒数第 ii 列的第 jj 个位置。
     * @param matrix
     */
    fun rotate(matrix: Array<IntArray>) {
        val len = matrix.size
        if (len == 1) return

        val newMatrix = Array(len) { IntArray(len) }
        for (row in 0 until len) {
            for (col in 0 until len) {
                newMatrix[col][len - 1 - row] = matrix[row][col]
            }
        }
        for (row in 0 until len) {
            for (col in 0 until len) {
                matrix[row][col] = newMatrix[row][col]
            }
        }

    }

    /**
     * 零矩阵，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     * @param matrix
     */
    fun setZeroes(matrix: Array<IntArray>) {
        val rowLen = matrix.size
        val colLen = matrix.first().size
        val newMatrix = Array(rowLen) { IntArray(colLen) }
        for (row in 0 until rowLen) {
            for (col in 0 until colLen) {
                newMatrix[row][col] = matrix[row][col]
            }
        }
        for (row in 0 until rowLen) {
            for (col in 0 until colLen) {
                if(matrix[row][col] == 0){
                    for (zeroRow in 0 until rowLen) {
                        newMatrix[zeroRow][col] = 0
                    }
                    for (zeroCol in 0 until colLen) {
                        newMatrix[row][zeroCol] = 0
                    }
                }
            }
        }

        for (row in 0 until rowLen) {
            for (col in 0 until colLen) {
                matrix[row][col] = newMatrix[row][col]
            }
        }
    }

}
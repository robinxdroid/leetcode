package com.github.leetcode.array

/**
 * 数组简介
 * @author wangbin@huami.com <br></br>
 * @since 2021/1/26
 */
object Introduction {

    /**
     * 寻找数组中心索引
     * 满足leftSum = sum - nums[i] - leftSum
     */
    fun findMiddleIndex(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1
        }
        val sum = nums.sum()
        var result = -1
        var leftSum = 0
        run loop@{
            nums.forEachIndexed { index, value ->
                if (leftSum == sum - value - leftSum) {
                    result = index
                    return@loop
                }
                leftSum += value
            }
        }

        return result
    }

    /**
     * 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。你可以假设数组中无重复元素。
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.contains(target)) {
            return nums.indexOf(target)
        }
        var result = 0
        if (target < nums.first()) {
            return result
        }
        if (target > nums.last()) {
            return nums.size
        }
        run loop@{
            nums.forEachIndexed { index, value ->
                if (target >= value && target < nums[index + 1]) {
                    result = index + 1
                    return@loop
                }
            }
        }
        return result
    }

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
}
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
}
package com.github.leetcode

import com.github.leetcode.array.Introduction

/**
 * @author wangbin@huami.com <br></br>
 * @since 2021/1/26
 */
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val temp = intArrayOf(-1, -1, -1, -1, -1, 0)
        val result = Introduction.findMiddleIndex(temp)
        print(result)
    }
}
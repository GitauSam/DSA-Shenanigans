package com.zenza.dsa.leet

fun twoSum(nums: IntArray, target: Int): IntArray {
    for ((index, value) in nums.withIndex()) {
        var diff = target - value
        if (nums.contains(diff) && index != nums.indexOf(diff)) {
            return intArrayOf(index, nums.indexOf(diff))
        }
    }

    return intArrayOf(-1, -1)
}

fun main() {
    val a = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(twoSum(a, 8))
}
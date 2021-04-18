package com.zenza.dsa.arrays

import java.util.*

class RotateArray {

    fun rotate(a: IntArray, f: Int): IntArray {
        val rotatedArr = IntArray(a.size)
        println("rotatedArr size: ${rotatedArr.size}")
        for ((index, value) in a.withIndex()) {
            println("evaluating index: $index, value: $value")
            when (index < (a.size - f)) {
                true -> {
                    println("index: $index < rotation factor: $f")
                    println("new pos: ${index + (a.size - f)}")
                    rotatedArr[index + (a.size - f)] = value
                }
                else -> {
                    println("index: $index >= rotation factor: $f")
                    println("new pos: ${index - (a.size - f)}")
                    rotatedArr[index - (a.size - f)] = value
                }
            }
        }
        return rotatedArr
    }

    fun refactoredRotate(a: IntArray, f: Int): IntArray {
        var rotatedArr = a
        var factor = f

        while (factor > 0) {
            rotatedArr = offsetArrayValuesByOne(rotatedArr)
            factor--
        }

        return rotatedArr
    }

    private fun offsetArrayValuesByOne(arr: IntArray): IntArray {
        val resArr = IntArray(arr.size)

        for ((index, value) in arr.withIndex()) {
            when (index == (arr.size-1)) {
                true -> {
                    resArr[0] = value
                }
                else -> {
                    resArr[index + 1] = value
                }
            }
        }

        return resArr
    }

}
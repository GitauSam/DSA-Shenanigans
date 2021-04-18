package com.zenza.dsa.ms

class LargestPossibleEvenSum {

    fun getLargestEvenPossibleSum(A: IntArray, K: Int): Int {
        var output = 0
        var newOutput = 0
        var lastIndex = 0
        if (K > A.size) return -1
        if (K == 1) {
            for (i in A) {
                when (i%2 == 0) {
                    true -> if (i > output) output = i
                }
            }
            if (output == 0) return -1
        }

        for (i in 0 until K) {
            output += A[i]
            lastIndex = i
        }

        if (output % 2 != 0) output = 0

        while (lastIndex < A.size) {
            for (i in 0 until K) {
                output += A[i]
            }
            lastIndex++
            newOutput += A[lastIndex]
            when (output%2 == 0) {
                true-> {
                    if (newOutput > output) output = newOutput
                }
                else-> {
                    output = 0
                }
            }
        }

        if (lastIndex == A.size) {

        }

        return output
    }
}
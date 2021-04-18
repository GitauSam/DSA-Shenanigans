package com.zenza.dsa.arrays

class DetermineUnpairedElement {

    fun returnUnpairedElm (arr: IntArray): Int {

        for (i in arr) {
            if (!pairExists(arr, i)) {
                return i
            }
        }

        return 0
    }

    fun pairExists(arr: IntArray, candidate: Int): Boolean {

        var count = 0

        for (i in arr) {
            if (i == candidate) {
                count ++
            }
        }

        if (count > 1) return true

        return false

    }
}
package com.zenza.dsa.ms

class SmallestPossibleValue {

    fun getSmallestPossibleValue(n: Int): Int {

        if (n < 1) return -1
        if (n == 1) return 0
        if (n > 1000000000) return -1
        var smallestPossibleValue = "1"
        for(i in 1 until n.toString().toCharArray().size) {
            smallestPossibleValue += "0"
        }

        return smallestPossibleValue.toInt()
    }
}
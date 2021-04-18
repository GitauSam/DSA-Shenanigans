package com.zenza.dsa.treehouse

fun recursiveFactorial(n: Int): Int {
    if (n == 2) {
        return 2
    }
    return n * recursiveFactorial(n - 1)
}

fun iterativeFactorial(n: Int): Int {
    var res = 1
    var n_ = n
    while (n_ > 1) {
        res *= n_
        n_--
    }

    return res
}


fun main() {
    println(recursiveFactorial(5))
    println(iterativeFactorial(5))
}
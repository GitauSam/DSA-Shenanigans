package com.zenza.dsa.treehouse

fun recursiveFib(n: Int): Int {
    if (n == 0) return 1
    if (n == 1) return 1
    return recursiveFib(n - 1) + recursiveFib(n-2)
}

fun iterativeFib(n: Int): Int {
    if(n < 1) return 1

    var sum = 0
    var prevSum = 1
    var b = 1

    for (i in 2..n) {
        sum = prevSum + b
        b = prevSum
        prevSum = sum
    }

    return sum

}



fun main() {
    println(recursiveFib(10))
    println(iterativeFib(10))
}
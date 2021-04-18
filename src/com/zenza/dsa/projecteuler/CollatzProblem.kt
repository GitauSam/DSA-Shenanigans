package com.zenza.dsa.projecteuler

class CollatzProblem {

    fun largestChainUnderMillion() {

        var res = hashMapOf<Long, Long>()
        val memo = hashMapOf<Long, Long>()

        res[1]=0

        for (i in 1L until 1000000L) {
            val p = collatz(i, memo)
            if (p[i]!! > res.values.stream().findFirst().get()) res = p
        }

        print("${res.keys}: ")
        print("${res.values}")

    }

    fun collatz(startingNo: Long, memo: HashMap<Long, Long> = hashMapOf()): HashMap<Long, Long> {

        var terms = 1L

        var startingNo_ = startingNo

        while (startingNo_ != 1L && startingNo_ > 1) {
            when(startingNo_%2) {
                0L -> {
                    if (memo.containsKey(startingNo_)) {
                        startingNo_ = memo[startingNo_]!!
                    } else {
                        memo[startingNo_] = startingNo_ / 2
                        startingNo_ = memo[startingNo_]!!
                    }
                }
                else -> {
                    if (memo.containsKey(startingNo_)) {
                        startingNo_ = memo[startingNo_]!!
                    } else {
                        memo[startingNo_] = (3*startingNo_) + 1
                        startingNo_ = memo[startingNo_]!!
                    }
                }
            }
            ++terms
        }

        val r = hashMapOf<Long, Long>()
        r[startingNo] = terms

        return r
    }

}
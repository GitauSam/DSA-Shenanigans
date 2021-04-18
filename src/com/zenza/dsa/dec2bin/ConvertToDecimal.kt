package com.zenza.dsa.dec2bin

import java.math.BigInteger

class ConvertToDecimal {

    fun convertDecToBin(dec: Int): BigInteger {

        var candidateDec = dec.toBigInteger()
        var convertedBin: BigInteger = BigInteger.ZERO
        var pos: BigInteger = BigInteger.ONE

        while (candidateDec > BigInteger.ZERO) {
            convertedBin += ((candidateDec.mod(2.toBigInteger())) * pos)
            candidateDec /= BigInteger.TWO
            pos *= BigInteger.TEN
        }

        return convertedBin
    }

    fun getLongestBinaryGap(candidateBin: BigInteger): Int {
        val binStrArr = candidateBin.toString().toCharArray()
        var startCount = 0
        var binGap = 0
        var longestBinGap = 0

        for (bin in binStrArr) {
            if (bin == "1".single() && startCount == 0) startCount = 1
            if (bin == "0".single() && startCount == 1) binGap++
            if (bin == "1".single() && startCount == 1) {
                when (binGap > longestBinGap) {
                    true -> {
                        longestBinGap = binGap
                        binGap = 0
                    }
                    else -> binGap = 0
                }
            }
        }

        return longestBinGap
    }

    fun convertDecToBinTry2(dec: Int): ArrayList<Int> {
        val binList = arrayListOf<Int>()
        var candidate = dec

        while (candidate > 1) {
            binList.add(candidate%2)
            candidate = (candidate/2)
        }

        binList.add(1)

        return binList
    }

    fun getLongestBinGap(dec: Int): Int {

        var current = 0
        var cand = 0
        var toCount = 0
        val binList = convertDecToBinTry2(dec)

        for (i in binList) {
            if (i == 1) {
                current = when (current >= cand) { true -> current else ->cand }
                cand = 0
                toCount = 1
            } else if (i == 0 && toCount == 1) {
                cand++
            }
        }

        return current

    }

}
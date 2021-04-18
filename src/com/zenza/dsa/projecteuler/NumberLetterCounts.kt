package com.zenza.dsa.projecteuler

fun numberLetterCounts(): Int {
    val ones = hashMapOf<String, String>()
    ones["1"] = "one"
    ones["2"] = "two"
    ones["3"] = "three"
    ones["4"] = "four"
    ones["5"] = "five"
    ones["6"] = "six"
    ones["7"] = "seven"
    ones["8"] = "eight"
    ones["9"] = "nine"

    val tens = hashMapOf<String, String>()
    tens["10"] = "ten"
    tens["11"] = "eleven"
    tens["12"] = "twelve"
    tens["13"] = "thirteen"
    tens["14"] = "fourteen"
    tens["15"] = "fifteen"
    tens["16"] = "sixteen"
    tens["17"] = "seventeen"
    tens["18"] = "eighteen"
    tens["19"] = "nineteen"
    tens["20"] = "twenty"
    tens["2"] = "twenty"
    tens["3"] = "thirty"
    tens["4"] = "forty"
    tens["5"] = "fifty"
    tens["6"] = "sixty"
    tens["7"] = "seventy"
    tens["8"] = "eighty"
    tens["9"] = "ninety"


    val hundreds = hashMapOf<String, String>()
    hundreds["1"] = "onehundred"
    hundreds["2"] = "twohundred"
    hundreds["3"] = "threehundred"
    hundreds["4"] = "fourhundred"
    hundreds["5"] = "fivehundred"
    hundreds["6"] = "sixhundred"
    hundreds["7"] = "sevenhundred"
    hundreds["8"] = "eighthundred"
    hundreds["9"] = "ninehundred"

    var wordCount = 0
    var numberInWords = ""

    for (i in 1..1000) {
        when(i.toString().toCharArray().size) {
            1 -> {
                numberInWords = ones[i.toString()]!!
                wordCount += numberInWords.toCharArray().size
            }
            2 -> {
                wordCount += when(i < 21) {
                    true -> {
                        numberInWords = tens[i.toString()]!!
                        numberInWords.toCharArray().size
                    }
                    else -> {
                        when(i.toString().toCharArray()[1] == '0') {
                            true -> {
                                numberInWords = tens[i.toString().toCharArray()[0].toString()]!!
                                numberInWords.toCharArray().size
                            }
                            else -> {
                                numberInWords = (tens[i.toString().toCharArray()[0].toString()] + ones[i.toString().toCharArray()[1].toString()]!!)
                                numberInWords.toCharArray().size
                            }
                        }
                    }
                }
            }
            3 -> {
                when(i.toString().toCharArray()[1] == '0') {
                    true -> {
                        wordCount += when(i.toString().toCharArray()[2] == '0') {
                            true -> {
                                numberInWords = hundreds[i.toString().toCharArray()[0].toString()]!!
                                numberInWords.toCharArray().size
                            }
                            else -> {
                                numberInWords = (hundreds[i.toString().toCharArray()[0].toString()] + "and" + ones[i.toString().toCharArray()[2].toString()])
                                numberInWords.toCharArray().size
                            }
                        }
                    }
                    else -> {
                        wordCount += when((i.toString().toCharArray()[1].toString() + i.toString().toCharArray()[2]).toInt() < 21) {
                            true -> {
                                numberInWords = (hundreds[i.toString().toCharArray()[0].toString()] + "and"
                                                    + tens[i.toString().toCharArray()[1].toString() + i.toString().toCharArray()[2]])
                                numberInWords.toCharArray().size
                            }
                            else -> {
                                when(i.toString().toCharArray()[2] == '0') {
                                    true -> {
                                        numberInWords = (hundreds[i.toString().toCharArray()[0].toString()] + "and"
                                                            + tens[i.toString().toCharArray()[1].toString()])
                                        numberInWords.toCharArray().size
                                    }
                                    else -> {
                                        numberInWords = (hundreds[i.toString().toCharArray()[0].toString()] + "and"
                                                            + tens[i.toString().toCharArray()[1].toString()]
                                                            + ones[i.toString().toCharArray()[2].toString()])
                                        numberInWords.toCharArray().size
                                    }
                                }
                            }
                        }
                    }
                }
            }
            4 -> {
                numberInWords = "onethousand"
                wordCount += numberInWords.toCharArray().size
            }
        }
    }

    return wordCount
}

fun main() {
    println(numberLetterCounts())
}
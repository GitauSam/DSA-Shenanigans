package com.zenza.dsa;

import com.zenza.dsa.arrays.Array;
import com.zenza.dsa.arrays.RotateArray;
import com.zenza.dsa.dec2bin.ConvertToDecimal;
import com.zenza.dsa.linkedlists.LinkedList;
import com.zenza.dsa.linkedlists.MySinglyLinkedList;
import com.zenza.dsa.ms.SmallestPossibleValue;
import com.zenza.dsa.projecteuler.CollatzProblem;
import com.zenza.dsa.projecteuler.SumOfHundredFiftyNumbers;

import java.util.Arrays;

public class Main {

    static MySinglyLinkedList myList = new MySinglyLinkedList();

    public static void main(String[] args) {
        testRotateArray();
    }

    static void testLinkedListOps() {
        var list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.removeFirst();
    }

    static void testMySinglyLinkedListAddFirst() {
        myList.addFirst(500);
        myList.addFirst(400);
        myList.addFirst(300);
        myList.addFirst(200);
        myList.addFirst(100);
        myList.addFirst(50);
    }

    static void testMySinglyLinkedListAddLast() {
        myList.addLast(50);
        myList.addLast(100);
        myList.addLast(150);
        myList.addLast(200);
        myList.addLast(250);
        myList.addLast(300);
    }

    static void testMySinglyLinkedListRemoveFirst() {
        testMySinglyLinkedListAddLast();
        myList.removeFirst();
        myList.removeFirst();
    }

    static void testMySinglyLinkedListRemoveLast() {
        testMySinglyLinkedListAddLast();
        myList.removeLast();
        myList.removeLast();
    }

    static void testMySinglyLinkedListContains() {
        testMySinglyLinkedListAddLast();
        System.out.println(myList.contains(2000));
    }

    static void testMySinglyLinkedListIndexOf() {
        testMySinglyLinkedListAddLast();
        var indexOf50 = myList.indexOf(50);
        var indexOf200 = myList.indexOf(200);
        var indexOf250 = myList.indexOf(250);
        System.out.println(indexOf50);
        System.out.println(indexOf200);
        System.out.println(indexOf250);
    }

    static void testConvertToDecimalAndGetLongestBinaryGap() {
        var convertToDecimal = new ConvertToDecimal();
        var bin = convertToDecimal.convertDecToBin(1610612737);
        System.out.println(bin);
        System.out.println(convertToDecimal.getLongestBinaryGap(bin));
    }

    static void testSmallestPossibleValue() {
        var smallestPossibleValue = new SmallestPossibleValue();
        System.out.println(smallestPossibleValue.getSmallestPossibleValue(123));
    }

    static void testFirstTenDigitsOfSumOfHundredFiftyDigits() {
        SumOfHundredFiftyNumbers s = new SumOfHundredFiftyNumbers();
        s.sum();
    }

    static void testCollatzProblem() {
        CollatzProblem collatzProblem = new CollatzProblem();
        collatzProblem.largestChainUnderMillion();
    }

    static void testDec2BinTry2() {
        ConvertToDecimal c = new ConvertToDecimal();

        System.out.println(c.getLongestBinGap(34));
    }

    static void testRotateArray() {
        RotateArray rotateArray = new RotateArray();
        int [] a = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(rotateArray.refactoredRotate(a, 4)));
    }
}

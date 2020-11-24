package com.zenza.dsa;

import com.zenza.dsa.arrays.Array;
import com.zenza.dsa.linkedlists.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println(list.indexOf(20));
        System.out.println(list.contains(300));
    }
}

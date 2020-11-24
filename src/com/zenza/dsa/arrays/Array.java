package com.zenza.dsa.arrays;

/**
 * Class implementing custom array operations solution.
 */
public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        /**
         * If array is full, resize it.
         * Add new item at the end;
         */
        if (items.length == count) {
            // create new array (e.g. twice the size)
            int[] newItems = new int[count * 2];

            // copy all the existing items
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            // set existing values to this array
            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        // validate index
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        // shift items to the left to fill the hole
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item) {
        // loop thru elements, if element is found, return index
        // otherwise, -1
        // Best Case O(1)
        // Worst Case O(n)

        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}

package com.subhajit.HashTableLab;

import java.util.Hashtable;

public class HashTableLabMain {
    public static void main(String[] args) {
        // all operational methods are synchronized
        Hashtable<Integer, String> hashTable = new Hashtable<>();

        hashTable.put(10, "Subhajit");
        hashTable.put(5, "Asim");
        hashTable.put(20, "Suman");
        hashTable.put(7, "Ram");
        hashTable.put(18, "Sourav");
        hashTable.put(18, "Raja");
        //hashTable.put(null, "Raja"); // null key not allowed, throws NPE
        //hashTable.put(1, null); // null value not allowed, throws NPE

        System.out.println("hashTable : " + hashTable);

    }
}

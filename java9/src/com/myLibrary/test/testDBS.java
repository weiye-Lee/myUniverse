package com.myLibrary.test;

import com.myLibrary.database.Database;
/*
* 测试Database
* */
public class testDBS {
    public static void main(String[] args) {
        Database.getLibraryBooks().get(0).setBorrowPerson("lalala");
        Database.getLibraryBooks()
                .forEach(a -> System.out.println(a.getBorrowPerson()));
    }
}

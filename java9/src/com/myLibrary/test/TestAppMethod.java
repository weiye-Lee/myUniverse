package com.myLibrary.test;

import com.myLibrary.App;
import com.myLibrary.AppMethod;
import com.myLibrary.database.BorrowedRecordDatabase;
import com.myLibrary.database.Database;

/*
* 测试app方法模块*/
public class TestAppMethod {
    public static void main(String[] args) {
        //BorrowedRecordDatabase borrowedRecordDatabase = new BorrowedRecordDatabase();
        Boolean str = AppMethod.borrow("root");
        Database.getLibraryBooks()
                .stream()
                .forEach(a -> System.out.println(a.getBorrowPerson()));

        // 测试 returnBook
        AppMethod.returnBook("root");
        Database.getLibraryBooks()
                .stream()
                .forEach(a -> System.out.println(a.getBorrowPerson()));

        // 测试借阅记录
        AppMethod.getBorrowedRecord("root");

    }

}

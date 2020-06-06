package com.myLibrary.test;

import com.myLibrary.borrowBook.BorrowBook;
import com.myLibrary.database.BorrowedRecordDatabase;
import com.myLibrary.database.Database;

/*
* 测试借书模块
* 费老劲了。。。
* */
public class TestBorrow {
    public static void main(String[] args) {
        // 测试 信息正确
        BorrowBook.borrow("lwy",5);
        Database.getLibraryBooks()
                .stream()
                .forEach(a -> System.out.println(a.getBorrowPerson()));
        BorrowedRecordDatabase.getBorrowedRecord()
                .get("lwy")
                .forEach(a -> System.out.println(a.getBorrowPerson() + " : "
                        + a.getBookName()));

        // 测试 信息错误
        BorrowBook.borrow("root",5); // 已经被借走
        BorrowBook.borrow("张三",7); // 没有这本书

    }
}

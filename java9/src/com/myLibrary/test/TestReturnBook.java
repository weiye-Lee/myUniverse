package com.myLibrary.test;

import com.myLibrary.database.BorrowedRecordDatabase;
import com.myLibrary.database.Database;
import com.myLibrary.returnBook.ReturnBook;

/*
* 测试还书模块
* 要实现借阅记录数据库才能完成还书测试*/
public class TestReturnBook {
    public static void main(String[] args) {
        // 测试正常还书
        BorrowedRecordDatabase borrowedRecordDatabase = new BorrowedRecordDatabase();
        ReturnBook.retunrBook(2,"root");
        Database.getLibraryBooks()
                .stream()
                .forEach(a -> System.out.println(a.getBorrowPerson()));

        // 测试 信息错误的还书
        /*2020.5.26测试失败，目前只能信息正确还书，否则空指针异常
        * 2020.5.27测试成功，空指针异常由 .equal() 导致
        * */

        ReturnBook.retunrBook(2,"root");
        ReturnBook.retunrBook(9,"lwy");
    }
}

package com.myLibrary.test;

import com.myLibrary.books.Book;
import com.myLibrary.database.BorrowedRecordDatabase;
import com.myLibrary.database.Database;
import com.myLibrary.recommend.Recommend;

import java.util.stream.Collectors;

/*
* 测试推荐模块*/
public class TestRecommend {
    public static void main(String[] args) {
        BorrowedRecordDatabase borrowedRecordDatabase = new BorrowedRecordDatabase();
        Recommend.recommend("root")
                .forEach(a -> System.out.println(a.getBookName()));
    }
}

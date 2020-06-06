package com.myLibrary.test;

import com.myLibrary.books.Book;
import com.myLibrary.database.DBMS;
import com.myLibrary.database.Database;

import java.util.stream.Collectors;

/*
* 测试 DBMS 中的加入和删除借阅记录
* 书籍序列号从1开始，如果对 id = 0 进行操作会越界，*/
public class testDBMs {
    public static void main(String[] args) {
        /*
        Boolean str = DBMS.addRecord(0,"root");
        System.out.println(str);

         */
         Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == 1)
                .forEach(a -> System.out.println(a.getId()));
    }
}

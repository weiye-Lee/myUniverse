package com.myLibrary.database;

import com.myLibrary.books.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    // 尝试用python的方式处理json文件，失败

    private final static Map<String,String> USERSPSW = createUsersPsw(); // 存储账号密码
    private static Map<String,String> createUsersPsw() {
        // 完成对用户的账号密码完成初始化
        String account = "root";
        String psw = "root";
        Map<String,String> m = new HashMap<>();
        m.put(account,psw);
        return m;
    }
    private final static List<Book> LIBRARY_BOOKS = createLibBooks();
    private static List<Book> createLibBooks() {
        // 完成对书籍信息的初始化
        Book book1 = new Book("人性的弱点", Book.dir.psychology,"卡内基","暂无",1);
        Book book2 = new Book("论李伟业的运气", Book.dir.psychology,"李伟业","暂无",2);
        Book book3 = new Book("二狗子的成长史", Book.dir.Literature,"二狗子","暂无",3);
        Book book4 = new Book("张三的罪状", Book.dir.tools,"三老师","暂无",4);
        Book book5 = new Book("java是世界上最好的语言", Book.dir.science,"李伟业","把刀放下把...",5);
        List<Book> l = new ArrayList<>();
        l.add(book1);
        l.add(book2);
        l.add(book3);
        l.add(book4);
        l.add(book5);
        return l;
    }
    public static Map<String, String> getUSERSPSW() {
        return USERSPSW;
    }

    public static List<Book> getLibraryBooks() {
        return LIBRARY_BOOKS;
    }
}

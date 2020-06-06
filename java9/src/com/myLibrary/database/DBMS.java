package com.myLibrary.database;

import com.myLibrary.App;
import com.myLibrary.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
* 数据库管理系统
* 包括借书还书修改对应书籍借阅情况(borrowPerson)的修改
* 包括对借阅记录(borrowRecord)的修改
* */
public class DBMS {
    public static Boolean addBPSituation(int id,String account) { // 仅支持对书籍根据书籍 id 的操作
        // addBorrowPersonSituation 用于借书
        Book book = Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList())
                .get(0);

        if (book == null) { // 找不到图书，id有错误
            return false;
        }
        else {
            book.setBorrowPerson(account);
            return true;
        }
    }
    public static Boolean delBPSituation(int id,String account) { // 仅支持对书籍根据书籍 id 的操作
        // deleteBorrowPersonSituation 用于还书
        Book book = Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList())
                .get(0);

        if (book == null) {
            return false;
        }
        else {
            book.setBorrowPerson(null); // 没有人借阅，借阅信息为空
            return true;
        }
    }
    public static void addBorrowRecord(int id,String account) {
        /*addBorrowRecord Record 添加借阅记录
        * 前提条件 id 必须有效*/
        Book book = Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList())
                .get(0);

        /*BorrowedRecordDatabase.getBorrowedRecord().get(account).add(book);
        * 以上为错误写法，由于某个用户可能没有借阅记录，get(account) 会空指针异常
        * 要先判断该账号有没有借阅记录，没有 创建，有 直接加*/
        List<Book> BRDList = BorrowedRecordDatabase.getBorrowedRecord().get(account);
        if (BRDList == null) {
            BRDList = new ArrayList<>();
            BRDList.add(book);
            BorrowedRecordDatabase.getBorrowedRecord().put(account,BRDList);
        }
        else BorrowedRecordDatabase.getBorrowedRecord().get(account).add(book);


    }
    public static void addBook(Book abook) {
        /*id 作为唯一标识符，不能重复，这里判断
        * 应该检查用户账号 ， 只有root账户才能添加书籍*/
        if (App.Account.equals("root") == false) {
            System.out.println("无权限");
            return;
        }
        else {
            int id = abook.getId();
            List<Book> checkedList = Database.getLibraryBooks()
                    .stream()
                    .filter(a -> a.getId() == id)
                    .collect(Collectors.toList());
            if (checkedList == null) {
                Database.getLibraryBooks().add(abook);
            } else {
                System.out.println("id作为唯一标识符不能重复，你想啥呢");
            }
        }

    }
}

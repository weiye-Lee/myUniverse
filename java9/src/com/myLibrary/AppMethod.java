package com.myLibrary;

import com.myLibrary.books.Book;
import com.myLibrary.borrowBook.BorrowBook;
import com.myLibrary.database.BorrowedRecordDatabase;
import com.myLibrary.database.Database;
import com.myLibrary.recommend.Recommend;
import com.myLibrary.returnBook.ReturnBook;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
* 包括App中用户所有可以执行操作的方法*/
public class AppMethod {
    private static Database database = new Database();
    private static BorrowedRecordDatabase borrowedRecordDatabase = new BorrowedRecordDatabase();
    public static Boolean borrow(String account) {
        // 借书方法
        System.out.println("哇啦啦啦啦，你终于来借书了");
        System.out.println("请输入书籍id");
        System.out.print(">>>");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        Boolean state = BorrowBook.borrow(account,id);
        return state;
    }
    public static Boolean returnBook(String account) {
        // 还书方法
        System.out.println("哇啦啦啦啦，你来还书了");
        System.out.println("请输入书籍id");
        System.out.print(">>>");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        Boolean state = ReturnBook.retunrBook(id,account);

        // 以下为个性化推荐
        System.out.println("鉴于你的浏览情况，我们给你推荐了如下书籍");
        List<Book> recommendBook = Recommend.recommend(account);
        Book bookInfo = recommendBook.get(recommendBook.size()-1);
        System.out.println("id: " + bookInfo.getId() + " name: " + bookInfo.getBookName());
        return state;
    }
    public static void getBorrowedRecord(String account) {
        // 获取借阅记录
        List<Book> userBist = BorrowedRecordDatabase.getBorrowedRecord().get(account);
        if (userBist == null) {
            System.out.println("你还没有借阅记录，快借点书吧~");
        }
        else {
            System.out.println("你的全部借阅记录如下");
            userBist.forEach(a -> {
                System.out.print("id: " + a.getId());
                System.out.println(" name: " + a.getBookName());
            });
        }
    }
    public static void bookToBeReturn(String account) {
        // 获取待还书籍
        List<Book> bookName = Database.getLibraryBooks()
                .stream()
                .filter(a -> account.equals(a.getBorrowPerson()))
                .collect(Collectors.toList());
        if (bookName.isEmpty()) {
            System.out.println("很棒呦，你没有待还书籍呢");
        }
        else{
            System.out.println("待还书籍如下");
            bookName.forEach(a -> {
                System.out.print("id: " + a.getId());
                System.out.println(" name: " + a.getBookName());
            });
        }
    }
}

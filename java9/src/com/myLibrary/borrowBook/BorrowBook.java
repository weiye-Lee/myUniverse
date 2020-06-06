package com.myLibrary.borrowBook;

import com.myLibrary.books.Book;
import com.myLibrary.database.DBMS;
import com.myLibrary.database.Database;

import java.util.Optional;
import java.util.stream.Collectors;

/*
* 借书模块
* 传递参数（account，Book.id)
* 返回Book
* 包括id检查 -> 修改书籍借阅情况（borrowPerson) -> 添加借阅记录
* */
public class BorrowBook {
    private static int checkId(int id) {
        // 检查 id 是否有效
        /*
        List<Book> bookList = Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList());
        if (bookList == null) {
            return null;
        }
        else {
            return bookList.get(0);
        }

        以下方法有待修改。。。
         */
        Optional<Book> optionalBook = Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        return optionalBook.map(a -> a.getId())
                .orElse(-1);
    }
    public static Boolean borrow(String account, int id) {
        /*
        * 最好的返回值时 Book 类*/
        int checked = checkId(id);
        if (checked == -1) {
            System.out.println("输入的id有错误");
            return false;
        }
        else if (Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList())
                .get(0).getBorrowPerson()!= null) {
            System.out.println("这本书已经被借走了，啦啦啦");
            return false;
        }
        else {
            DBMS.addBPSituation(id, account);
            DBMS.addBorrowRecord(id, account);
            System.out.println("-借书成功啦-");
            return true;
        }
    }
}

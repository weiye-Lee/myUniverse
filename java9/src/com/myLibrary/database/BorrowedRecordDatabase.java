package com.myLibrary.database;

import com.myLibrary.App;
import com.myLibrary.books.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 书籍借阅数据库
* Map<account,List<Book>>
*/
public class BorrowedRecordDatabase {
    private static final Map<String, List<Book>> BorrowedRecord = createBRD();
    private static Map<String,List<Book>> createBRD() {

        /*
        * 完成对root用户借阅记录的创建
        * 包含连个·用户的借阅记录 root 和admin
        * */

        List<Book> list = new ArrayList<>();
        List<Book> list2 = new ArrayList<>();
        Map<String,List<Book>> m = new HashMap<>();
        // 以下 get 方法只用于数据库中， 集合中数据时无序的，这么添加只是为了偷懒
        list.add(Database.getLibraryBooks().get(1));
        list.add(Database.getLibraryBooks().get(3));
        list2.add(Database.getLibraryBooks().get(0));
        list2.add(Database.getLibraryBooks().get(2));

        // 借书后要对书籍的借阅形况( Book.borrowPerson )作出修改
        DBMS.addBPSituation(2,"root");
        DBMS.addBPSituation(4,"root");
        DBMS.addBPSituation(1,"admin");
        DBMS.addBPSituation(3,"admin");

        m.put("root",list);
        m.put("admin",list2);
        return m;
    }

    public static Map<String, List<Book>> getBorrowedRecord() {
        return BorrowedRecord;
    }
    /*
    * 以下为测试代码
    * */

    public static void main(String[] args) {
        createBRD();
        Database.getLibraryBooks()
                .stream()
                .forEach(a -> System.out.println(a.getBorrowPerson()));
    }
}

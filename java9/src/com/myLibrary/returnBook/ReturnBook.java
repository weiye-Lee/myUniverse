package com.myLibrary.returnBook;

import com.myLibrary.books.Book;
import com.myLibrary.database.DBMS;
import com.myLibrary.database.Database;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*还书模块
* 传递参数(account,Book.id)
* 需要验证 id 正确与否 and 账号有没有借这本书
* >>>空指针异常要我命啊<<<*/
public class ReturnBook {
    private static String checkId(int id,String account) {
        /*
        * 借书还书模块中的checkId方法都有待完善
        * 基于Optional方法这个没用明白*/
        /*
         List<Book> book = Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .filter(a -> a.getBorrowPerson().equals(account))
                .collect(Collectors.toList());
         if (book == null) {
             return null;
         }
         else return account;

         */
        Optional<Book> bookOptioal = Database.getLibraryBooks()
                .stream()
                .filter(a -> a.getId() == id)
                .filter(a -> account.equals(a.getBorrowPerson()))
                .findFirst();
        return bookOptioal.map(a -> a.getBorrowPerson())
                .orElse(null);

    }
    public static Boolean retunrBook(int id,String account) {
        String checked = checkId(id,account);
        if (checked == null) {
            System.out.println("还书失败，请检查输入信息");
            return false;
        }
        else {
            DBMS.delBPSituation(id, account);
            System.out.println("还书成功了");
            return true;
        }
    }
}

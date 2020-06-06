package com.myLibrary.recommend;

import com.myLibrary.books.Book;
import com.myLibrary.books.Book.dir;
import com.myLibrary.database.BorrowedRecordDatabase;
import com.myLibrary.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* 个性化推荐
* 传递参数账号(account)*/
public class Recommend {
    public static List<Book> recommend(String account) {
        List<Book> ans;
        List<Book> BRDist = BorrowedRecordDatabase.getBorrowedRecord().get(account);
        if (BRDist == null) {
            // 暂时先不管多少本书，都给他推荐
            ans = Database.getLibraryBooks()
                    .stream()
                    .filter(a -> a.getBorrowPerson() == null)
                    .collect(Collectors.toList());
        }
        else {
            Map<dir,Integer> bookRank = new HashMap<>();
            for (dir d : dir.values()) {
                bookRank.put(d,0);
            }
            Database.getLibraryBooks()
                    .stream()
                    .filter(a -> account.equals(a.getBorrowPerson()))
                    .forEach(a -> {
                        int rankNum = bookRank.get(a.getDir());
                        rankNum++;
                        bookRank.put(a.getDir(),rankNum);
                    });

            int wantMaxDir = -1;
            dir maxDir = null;
            for (dir key:bookRank.keySet()) {
                if (bookRank.get(key) > wantMaxDir) {
                    wantMaxDir = bookRank.get(key);
                    maxDir = key;
                }
            }
            dir finalMaxDir = maxDir;
            ans = Database.getLibraryBooks()
                    .stream()
                    .filter(a -> a.getDir().equals(finalMaxDir))
                    .collect(Collectors.toList());
        }
        return ans;
    }
}

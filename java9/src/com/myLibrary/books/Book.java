package com.myLibrary.books;

public class Book {
    public enum dir {
        Literature, psychology, science, tools, foreign,languages
    }
    private String bookName; // 名称
    private dir dir; // 表示目录
    private String author; //作者
    private String otherInfo;
    private String borrowPerson; // 借阅者
    int id; // 书籍发行日期

    public Book(String bookName, Book.dir dir, String author, String otherInfo, int id){

        this.bookName = bookName;
        this.dir = dir;
        this.author = author;
        this.otherInfo = otherInfo;
        this.id = id;
        this.borrowPerson = null; // 默认每本书都没有人借走
    }

    public void setBorrowPerson(String borrowPerson) {
        // 用于表示这本书的借阅情况，有人借borrowPerson 为姓名，否则为空
        this.borrowPerson = borrowPerson;
    }

    public int getDate() {
        return id;
    }
    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public dir getDir() {
        return dir;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String getBorrowPerson() {
        return borrowPerson;
    }

    public int getId() {
        return id;
    }
}

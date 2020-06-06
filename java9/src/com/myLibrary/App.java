package com.myLibrary;

import com.myLibrary.login.Login;

import java.util.Scanner;
public class App {
    public static String Account; // 用于存储账户
    public static boolean loginFlag = false; // 登录判断量，只有值为真的情况才能执行header
    private static void validation() {
        if (loginFlag == false) {
            System.out.println("你还没有登录，请输入”L“进行登录操作");
            Scanner in = new Scanner(System.in);
            String oprtation = in.next(); // 用户输入
            if (oprtation.equals("L")){
                // 用户准备登录
                Login.login();
            }
            else{
                System.out.println("你不登陆啥也干不了-_-!");
            }
        }
        else {
            System.out.println("登录成功");
            System.out.println("正在加载，，，");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            App.header();
        }
    }
    private static void header() {
        // 展示登陆后的页面效果
        int opt = 314;
        Scanner in = new Scanner(System.in);
        while (opt != -1) {

            System.out.println("1：借书");
            System.out.println("2：还书");
            System.out.println("3：借阅记录");
            System.out.println("4：others");
            System.out.println("5：我的待还书籍");
            /*
            System.out.println("6：加入书籍");
            // 以上不用来展示，只是root用户可以操作
             */

            System.out.println("-1：退出");
            opt = in.nextInt();
            switch (opt) {
                case 1: // 借书
                    System.out.println("------------");
                    AppMethod.borrow(Account);
                    System.out.println("------------");
                    break;
                case 2: // 还书
                    System.out.println("------------");
                    AppMethod.returnBook(Account);
                    System.out.println("------------");
                    break;
                case 3: // 借阅记录
                    System.out.println("------------");
                    AppMethod.getBorrowedRecord(Account);
                    System.out.println("------------");
                    break;
                case 4: // others
                    System.out.println("------------");
                    System.out.println("预留的一个功能，不准你点");
                    System.out.println("------------");
                    break;
                case 5: // 查看待还书籍
                    System.out.println("------------");
                    AppMethod.bookToBeReturn(Account);
                    System.out.println("------------");
                    break;
                case 6: // 加入书籍
                    System.out.println("------------");

                    System.out.println("------------");
                case -1:
                    System.out.println("exit");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        while (loginFlag == false) {
            App.validation();
        }
        App.validation();
    }
}

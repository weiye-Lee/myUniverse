package com.myLibrary.login;


import com.myLibrary.App;
import com.myLibrary.database.Database;

import java.util.Map;
import java.util.Scanner;

public class Login {
    // 实现用户的登录操作，只有登录才能执行各种操作
    public static void login() {
        System.out.println("请输入账号");
        System.out.print(">>>");
        Scanner in = new Scanner(System.in);
        String account = in.next();
        System.out.println("请输入密码");
        System.out.print(">>>");
        String password = in.next();
        if (password.equals(Database.getUSERSPSW().get(account))){
            App.loginFlag = true;
            App.Account = account;
        }
        else{
            System.out.println("密码错误，你是不是猴子派来的救兵？");
        }

    }
}

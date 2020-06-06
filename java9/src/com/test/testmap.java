package com.test;

import com.myLibrary.database.Database;

public class testmap {
    public static void main(String[] args) {
        System.out.println(Database.getUSERSPSW().get("root"));

    }
}

package com.myLibrary.test;
import com.alibaba.fastjson.*;

import java.io.*;
import java.nio.file.Files;

public class testFastjson {
    public static void saveDataToFile(String fileName,String data) {
        BufferedWriter writer = null;
        File file = new File("c:\\"+ fileName + ".json");
        //如果文件不存在，则新建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件写入成功！");
    }
    public static void main(String[] args) throws FileNotFoundException {
        JSONObject object = new JSONObject();
        object.put("liweiye","best");
        String fileName = "C:/example/myjson.json";
        String ans = object.getString("liweiye");
        testFastjson.saveDataToFile("example\\myjson",ans);

    }
}
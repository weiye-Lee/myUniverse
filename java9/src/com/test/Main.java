package com.test;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C://example/my2.txt";
        createFile(fileName);
        writeToFile("我是李伟业",fileName);
        String copyFileName = "C://example/myCopy.txt";
        //copyByIO(fileName,copyFileName);
        String copyFileNameNio = "C://example/myCopyNio.txt";
        //copyByNIO(fileName,copyFileNameNio);
        deleteFile(copyFileNameNio);
        walkDirectories("C://example");
    }

    /**
     * 基于指定文件名称创建目录及文件
     * 如果文件已经存在，则忽略
     *
     * @param fileName
     */
    private static void createFile(String fileName) throws IOException {
        File dir=new File(fileName);
        if(!dir.exists())
            dir.createNewFile();
    }

    /**
     * 提示：文件以字节操作，因此可以
     * 字符串，转字节数组，直接基于Files写入文件
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile(String content, String fileName) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] buff = content.getBytes();
            fileOutputStream.write(buff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于基本IO，以及字节数组缓冲区，复制文件
     * 打印显示循环读写循环次数
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByIO(String sourceFile, String targetFile) throws IOException {
        File file = new File(targetFile);
        if(!file.exists()){
            file.createNewFile();
        }
        try(FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile);) {
            int c = 0;
            while ((c = fileInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于NIO，实现文件的复制
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByNIO(String sourceFile, String targetFile) throws FileNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile);) {
            fileInputStream.transferTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除文件
     *
     * @param fileName
     */
    private static void deleteFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.deleteIfExists(path);
    }

    /**
     * 遍历打印指定目录下全部目录/文件名称
     *
     * @param dir
     */
    private static void walkDirectories(String dir) throws IOException {
        Path path = Paths.get(dir);
        Files.walk(path).forEach(System.out::println);
    }
}


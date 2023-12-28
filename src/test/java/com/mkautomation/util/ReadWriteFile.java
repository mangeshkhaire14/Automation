package com.mkautomation.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {

    public static void readFile(String filePath) throws IOException {
        File file= new File(filePath);
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write("java 123");
        fileWriter.close();

        int ch;
        FileReader fileReader=new FileReader(file);
        while((ch=fileReader.read())!=-1){
            System.out.print((char)ch);
        }
        fileReader.close();
    }


    public static void main(String args[]) throws IOException {
        String filePath=System.getProperty("user.dir")+"//downloads//filehandling.txt";
        readFile(filePath);

    }
}

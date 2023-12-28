package com.mkautomation.util;

import java.io.*;
import java.util.Base64;

public class FileUtility {

    public static boolean isFileDownloaded(String fileName){

        File folder= new File(System.getProperty("user.dir")+"//downloads");

        File[] listOfFiles=folder.listFiles();

        boolean flag=false;
        for(File file:listOfFiles){
            if(file.isFile()) {
                System.out.println("File " + file.getName());
                if (file.getName().matches(fileName)) {
                    return true;
                }
            }
        }
        return flag;
    }

    /* Get the latest file from a specific directory*/
    private File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public static void main(String args[]) throws IOException {
        boolean isFileDownloaded=isFileDownloaded("test.xlsx");
        if(isFileDownloaded){
            System.out.println("File downloaded successfully");
        }else{
            System.out.println("File not downloaded successfully");
        }

        File file = new File(System.getProperty("user.dir")+"//downloads//readfile.txt");
        String path=System.getProperty("user.dir")+"//downloads//readfile.txt";
        byte[] data = Base64.getDecoder().decode(path);
        OutputStream stream = new FileOutputStream(System.getProperty("user.dir")+"//downloads//readfile.txt");

        stream.write(data);
        stream.close();
    }

}

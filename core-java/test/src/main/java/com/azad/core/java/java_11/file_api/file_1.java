package com.azad.core.java.java_11.file_api;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Java 11 introduced an easy way to read and write files by providing new overloaded methods without writing much boiler plate code.
 */
public class file_1 {
    public static void main(String[] args){
        try {

            // temp location for windows : C:\Users\hazri\AppData\Local\Temp\
            Path tempFilePath = Files.writeString(
               Path.of(File.createTempFile("tempFile", ".tmp").toURI()),
               "Welcome to TutorialsPoint", 
               Charset.defaultCharset(), StandardOpenOption.WRITE);
                
            String fileContent = Files.readString(tempFilePath);
   
            System.out.println(fileContent);
         } catch (IOException e) {
            e.printStackTrace();
         }
    }
}

package com.azad.core.java.java_8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * With Java 8, Base64 has finally got its due. Java 8 now has inbuilt encoder and decoder for Base64 encoding. In Java 8, we can use three types of Base64 encoding.
 * Simple − Output is mapped to a set of characters lying in A-Za-z0-9+/. The encoder does not add any line feed in output, and the decoder rejects any character other than A-Za-z0-9+/.
 * URL − Output is mapped to set of characters lying in A-Za-z0-9+_. Output is URL and filename safe.
 * MIME (email format) − Output is mapped to MIME friendly format. Output is represented in lines of no more than 76 characters each, and uses a carriage return '\r' followed by a linefeed '\n' as the line separator. No line separator is present to the end of the encoded output.
 */
public class base64_1 {
    public static void main(String[] args){
        /// - Encode using basic encoder
        String base64encodedString = "";
        try {
            // getEncoder() - basic encoder
            // getUrlEncoder()
            // getMimeEncoder()
            // convert string to byte and encode,  “UTF-8” character encoding by default. Character encoding basically interprets a sequence of bytes into a string of specific characters. The same combination of bytes can denote different characters in different character encoding
            base64encodedString = Base64.getEncoder().encodeToString("azadjava8base65".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
         System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);
		
         // Decode base64 encoded string
         byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
		
         try {
            System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));// convert byte to string
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

package com.azad.core.java.basic.randomstuff;

public class test {
    public static void main(String[] args){
        String username = "hazrid :APP_TYPE ;BOOST";
        //String username = "hazrid :APP_TYPE";
            int partnerNameIndex = username.lastIndexOf(";");
            String postfix = username.substring(partnerNameIndex+1, username.length()).trim();

            System.out.println(postfix);
    }
}

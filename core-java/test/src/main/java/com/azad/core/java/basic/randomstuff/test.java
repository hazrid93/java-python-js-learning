package com.azad.core.java.basic.randomstuff;

public class test {
    public static void main(String[] args){
        String username = "has:asd :APP_TYPE";
        String userNamePart = null;
        if (username.contains(":")) {
            int colonIndex = username.lastIndexOf(":");
            String prefix = username.substring(0, colonIndex);
            String postfix = username.substring(colonIndex+1, username.length());
            if(postfix.equals("APP_TYPE")){
                userNamePart = prefix;
            }

        }
        userNamePart = userNamePart == null ? username : userNamePart;
        System.out.println(userNamePart);
    }
}

package com.azad.core.java.reflection;


import java.lang.reflect.Method;

class Furniture {

    @MyAnnotation(capitalize = true)
    public void print(String furnitureName){
        System.out.println(furnitureName);
    }

    @MyAnnotation(capitalize = true)
    private void print2(String furnitureName){
        System.out.println(furnitureName);
    }

    static class Table {
        String name = "small wooden table";

        @MyAnnotation(capitalize = true)
        public void print(){
            System.out.println(this.name);
        }
    }

    static class Chair {
        String name = "small wooden chair";

        @MyAnnotation(capitalize = true)
        public void print(){
            System.out.println(this.name);
        }
    }
}

public class ReflectAnnotation_1 {

    public static void main(String[] args){
        ReflectAnnotation_1 reflectAnnotation1 = new ReflectAnnotation_1();
        reflectAnnotation1.printFurniture("special zal deco furniture");

        /*
        Furniture.Table table = new Furniture.Table();
        Furniture.Chair chair = new Furniture.Chair();
        table.print();
        chair.print();
         */
    }

    public void printFurniture(String furnitureName){
        Class<Furniture> classz = Furniture.class;
        try {
            Method[] methods = classz.getDeclaredMethods();

            for(Method method: methods){
                method.setAccessible(true);
                if(method.isAnnotationPresent(MyAnnotation.class)
                && method.getAnnotation(MyAnnotation.class).capitalize()){
                    Furniture furniture = new Furniture();
                    String upperCaseName = furnitureName.toUpperCase();
                    method.invoke(furniture, upperCaseName);
                }
            }
        } catch (Exception ex){
            System.out.println("Exception occured: " + ex.getMessage());
        }
    }
}

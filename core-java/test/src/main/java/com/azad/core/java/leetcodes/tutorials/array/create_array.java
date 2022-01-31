package com.azad.core.java.leetcodes.tutorials.array;

// example of dvd array https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3236/
public class create_array {
    public static void main(String[] args){
        //define array of object (but still empty)
        // Java always initializes empty Array slots to null if 
        // the Array contains objects, or to default values if it contains
        // primitive types. For example, the array int [] would contain the default value of 0
        //  for each element, float[] would contain default values of 0.0, and bool[] would contain default values of false.
        Dvd[] dvdArr = new Dvd[10];

        // get array length
        System.out.println(dvdArr.length);

        // add item into array
        // inserting item outside of 0-9 range (for size 10) will 
        // cause your code to crash with an ArrayIndexOutOfBoundsException!
        dvdArr[0] = new Dvd("name1", 2000, "dir1");
        dvdArr[7] = new Dvd("name7", 2000, "dir7");

        // same index will rewritten
        dvdArr[7] = new Dvd("name7#2", 2000, "dir7");
        
        // loop non null content
        /*
        for(int i = 0; i<dvdArr.length; i++){
            if(dvdArr[i] != null){
                System.out.printf("dvd content at %d: %s \n", i, dvdArr[i].name);
            }
        }
        */

        // OR loop with for each (no index number with this)
        for(Dvd dvd : dvdArr){
            if(dvd != null){
                System.out.printf("dvd content : " + dvd.name + "\n");
            }
        }
    }
}


class Dvd {
    public String name;
    public int releaseYear;
    public String director;

    public Dvd(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Dvd [director=" + director + ", name=" + name + ", releaseYear=" + releaseYear + "]";
    }

    
}
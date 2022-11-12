package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {

        //choose java.util library from the suggestion list
        //declare and define the arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //add values for countries
        countries.add("USA");
        countries.add("Canada");
        countries.add("India");
        countries.add("Bangladesh");

        //print USA from the array list
        System.out.println("Countries value: " + countries.get(0));
        //get me all the count of the countries
        System.out.println("Countries count: " + countries.size());

        //call an integer array list for streetNumber
        ArrayList<Integer> streetNumber = new ArrayList<>();
        //add values for streetNumber
        streetNumber.add(111);
        streetNumber.add(222);
        //print streetNumber
        System.out.println("First street number: " + streetNumber.get(0));
        //print count of street numbers
        System.out.println("Street number count: " + streetNumber.size());
    }//end of main
}//end of java class

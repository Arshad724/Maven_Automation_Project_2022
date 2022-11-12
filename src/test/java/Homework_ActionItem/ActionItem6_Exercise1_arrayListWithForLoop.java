package Homework_ActionItem;

import java.util.ArrayList;

public class ActionItem6_Exercise1_arrayListWithForLoop {
    public static void main(String[] args) {
        //Declaring country array list
        ArrayList<String> country = new ArrayList<>();
        //Defining country array list
        country.add("USA");
        country.add("Bangladesh");
        country.add("England");
        country.add("Mexico");
        //Declaring countryCode array list
        ArrayList<Integer> countryCode = new ArrayList<>();
        //Defining country code array list
        countryCode.add(1);
        countryCode.add(880);
        countryCode.add(44);
        countryCode.add(52);
        //call for loop to print out country and countryCode
        for(int i =0; i <=3; i++){

            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        }//end of for loop
    }//end of main
}//end of java class

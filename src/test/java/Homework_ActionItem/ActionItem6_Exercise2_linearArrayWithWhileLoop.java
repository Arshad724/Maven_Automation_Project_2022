package Homework_ActionItem;

public class ActionItem6_Exercise2_linearArrayWithWhileLoop {
    public static void main(String[] args) {
    //Declaring and defining region and areaCode
    String[] region = new String[]{"NY","CA","TX","PA"};
    int[] areaCode = new int[]{212,213,214,215};

    //Iterate through all region and areaCode using while loop and printing sentence
    int i = 0;
    while(i <= 3){

        System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);

        i++;

        }//end of while loop
    }//end of main
}//end of java class

package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] listOfDigits = new int[0];
        System.out.println("Enter an element you'd like to add to a list: ");
        while (!(scanner.hasNext("quit"))) {
            if (scanner.hasNextInt()) {
                int[] arrayTemp = new int[listOfDigits.length];   //creating a list using a temporary one
                for (int i = 0; i < listOfDigits.length; i++) {
                    arrayTemp[i] = listOfDigits[i];
                }
                listOfDigits = new int[arrayTemp.length + 1];
                for (int x = 0; x < arrayTemp.length; x++) {
                    listOfDigits[x] = arrayTemp[x];
                }
                listOfDigits[listOfDigits.length - 1] = scanner.nextInt(); //appending all the elements scanned
                scanner.nextLine();
                System.out.println("Enter another element: ");
            } else {
                System.out.println("Invalid data. Enter only integers.");
                return;
            }
        }
        System.out.println(Arrays.toString(listOfDigits));
        scanner.nextLine();
        System.out.println("Enter K, where K is the natural you want to smooth your list with: ");
        if (scanner.hasNextInt()) {
            int smoother = scanner.nextInt();
            int sum = 0;
            if (smoother > 0 & smoother < listOfDigits.length) { //checking if the entered K meets our requirements
                for (int j = 0; j < smoother; j++) {  //calculating the average of K first numbers in the list
                    sum = sum + listOfDigits[j];
                }
            } else {
                System.out.println("Invalid data. K must be among naturals and less than the length of the list");
            }
            int result;
            result = sum / smoother;

            int [] resultList2 = new int [listOfDigits.length]; //creating the first half of the new list (before K)
            for (int y = 0; y < smoother; y++){
                resultList2[y] = listOfDigits[y];
            }
            resultList2[smoother - 1] = result; //putting result into the list
            for (int c = smoother; c < listOfDigits.length; c++){ //adding the rest of the elements
                resultList2[c] = listOfDigits[c];
            }
            System.out.println(Arrays.toString(resultList2));
        }
        else {
            System.out.println("Invalid data. K must be among naturals");
        }
        scanner.close();
    }
}

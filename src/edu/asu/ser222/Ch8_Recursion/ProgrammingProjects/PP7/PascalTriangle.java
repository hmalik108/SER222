package edu.asu.ser222.Ch8_Recursion.ProgrammingProjects.PP7;

import java.util.Scanner;

/**
 * Created by Harish Malik on 3/19/16.
 *
 *
 * Determines and prints the Nth line of Pascal's Triangle.
 *
 * Solution to Programming Project 8.7.
 */
public class PascalTriangle {

    private int[] array;

    /**
     * Initializes the required array
     * @param row - No of row of Pascal Triangle to be printed
     */
    public PascalTriangle(int row){

        if(row<2){
            array = new int[]{1};
        }
        else
            array = new int[row];
    }

    /**
     * Check if the required row is valid or not. If not valid returns the 1st row
     * else call recursive function to compute the row
     */
    public void printLine(){

        if(array.length<2)
            return;
        else{
            array[0] =1;
            makeTriangle(1);
        }



    }

    /**
     * Computes recursively the required row of Pascal's Triangle
     * @param row - No of row of Pascal Triangle to be printed
     */
    private void makeTriangle(int row){


        if(row == array.length){
            printPascalTriangleLine(); // Using indirect recursion
        }

        else{
            for(int i= array.length-1 ; i>0;i--){
                array[i] += array[i-1];
            }
               makeTriangle(row+1);

        }

    }

    /**
     * Prints the final output
     */
    private void printPascalTriangleLine() {

        for(int i:array)
            System.out.print(i +" ");
    }


    public static void main(String[] args) {


        String printAnother = "y";
        Scanner sc = new Scanner(System.in);


        while(printAnother.equals("y")){
            System.out.println("Enter the line number to compute: ");
            int row = Integer.parseInt(sc.nextLine());
            PascalTriangle one = new PascalTriangle(row);
            System.out.println("Line "+row+" of Pascal Triangle is : ");
            one.printLine();
            System.out.println("\n\nWanna try again? (y/n) ");
            printAnother = sc.nextLine();

        }

    }


}

package edu.asu.ser222.Ch8_Recursion.ProgrammingProjects.toh;

/**
 * Created by HM on 3/19/16.
 */
public class TowersOfHanoi {


    private int noDisks;

    /**
     * Sets up the puzzle with the specified no of disks
     * @param noDisks - no of disks
     */
    public TowersOfHanoi(int noDisks){

        this.noDisks = noDisks;


    }


    /**
     * Perform the initial call to tohSolver to solve the puzzle
     * Moves the disks from Peg1 to Peg3 using Peg2
     */
    public void solver(){

        tohSolver(noDisks,1,3,2);

    }

    /**
     * Moves the specified number of disks from one Peg to another by moving a
     * a subtower of N-1 disks out of the way, moving one disk, then moving the
     * subtower back.
     * Base case of 1 disk
     * @param noDisks - no of disks to move
     * @param start - starting Peg
     * @param end - Ending Peg
     * @param temp - Temporary Peg
     */
    private void tohSolver(int noDisks,int start,int end,int temp){

        if(noDisks == 1){

            moveDisk(start,end);


        }

        else{

            tohSolver(noDisks-1,start,temp,end);
            moveDisk(start, end);
            tohSolver(noDisks-1,temp,end,start);
        }


    }


    /**
     * Prints instrutions to move one disk from the specified start peg to
     * the specified end peg.
     * @param start - starting peg
     * @param end - ending peg
     */
    private void moveDisk(int start,int end){

        System.out.println("Move disk from "+start+ " to "+end);
    }


}

package edu.asu.ser222.Ch8_Recursion.ProgrammingProjects.toh;

/**
 * Created by HM on 3/19/16.
 */
public class TowersOfHanoi {


    private int noDisks;

    public TowersOfHanoi(int noDisks){

        this.noDisks = noDisks;


    }



    public void solver(){

        tohSolver(noDisks,1,3,2);

    }


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


    private void moveDisk(int start,int end){

        System.out.println("Move disk from "+start+ " to "+end);
    }


}

package edu.asu.ser222.Ch8_Recursion.ProgrammingProjects.toh;

/**
 * Created by HM on 3/19/16.
 */
public class TOHSolver {


    /**
     * Creates a TowerOfHanoi instance and solves the puzzle using solver
     * method of TowerOfaHanoi class
     *
     */
    public static void main(String[] args) {

        TowersOfHanoi toh = new TowersOfHanoi(4);

        toh.solver();

    }

}

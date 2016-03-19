package edu.asu.ser222.Ch8_Recursion;

/**
 * Created by HM on 3/13/16.
 */
public class recurse2 {

    public static void recurse(int x){

        if(x<=1){
            System.out.print("***");
        }
        else if((x%2)==0){
            System.out.print(x);
            recurse(x-1);
        }
        else {
            System.out.print("+++");
            recurse(x-1);
        }
    }

  public static void main(String[] args) {

        recurse(3);
        System.out.print("---");
        recurse(2);

    }
}

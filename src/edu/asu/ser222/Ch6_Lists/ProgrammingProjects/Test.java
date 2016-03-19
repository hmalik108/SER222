package edu.asu.ser222.Ch6_Lists.ProgrammingProjects;

import edu.asu.ser222.Ch6_Lists.ProgrammingProjects.PP14.DoubleOrderedList;
import edu.asu.ser222.Ch6_Lists.ProgrammingProjects.PP14.DoubleNode;

import java.util.Iterator;

/**
 * Created by HM on 3/13/16.
 */
public class Test {

    public static void main(String[] args) {

        DoubleOrderedList<Integer> dList = new DoubleOrderedList<Integer>();

        dList.add(2);
        dList.add(12);
        dList.add(22);
        dList.add(32);
        dList.add(5);
        dList.add(1);
        dList.add(100);


        Iterator it = dList.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+"-");
        }



        System.out.println(dList.isEmpty());
        System.out.println("Size "+dList.size());
        System.out.println("First "+dList.first());
        System.out.println("Last "+dList.last());
        System.out.println(dList.removeFirst());
        System.out.println("First after removing first "+dList.first());




    }

}

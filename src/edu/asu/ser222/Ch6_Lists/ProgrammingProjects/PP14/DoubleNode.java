package edu.asu.ser222.Ch6_Lists.ProgrammingProjects.PP14;

import java.util.Comparator;

/**
 * Created by HM on 3/11/16.
 */
public class DoubleNode<T> implements Comparable<T> {


    private T element;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;



    public DoubleNode(){
        element = null;
        next = null;
        previous = null;
    }

    public DoubleNode(T item){
        this.element = item;
        this.next = null;
        this.previous = null;
    }

    public void setNext(DoubleNode<T> next){
        this.next = next;

    }


    public DoubleNode<T> getNext(){
        return next;
    }


    public void setPrevious(DoubleNode<T> previous){
        this.previous = previous;

    }

    public DoubleNode<T> getPrevious(){
        return previous;
    }


    public T getElement(){
        return element;
    }
    @Override
    public int compareTo(T o) {
        return 0;
    }
}

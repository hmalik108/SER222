package edu.asu.ser222.Ch6_Lists.ProgrammingProjects.PP14;

import edu.asu.ser222.Ch6_Lists.ProgrammingProjects.exceptions.NonComparableElementException;

/**
 *
 * DoubleOrderedList represents a singly linked implementation of an
 * ordered list.
 *
 * Created by HM on 3/12/16.
 */
public class DoubleOrderedList<T> extends DoubleList<T> implements DoubleListADT<T> {


    /**
     * Creates an empty list
     */
    public DoubleOrderedList(){
        super();

    }

    /**
     * Adds the specified element to this list at the location determined by
     * the element's natural ordering.
     * Throws a NonComparableElementException
     * if the element is not comparable.
     *
     *@param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
     */
    @Override
    public void add(T element) {

        {
            if (!(element instanceof Comparable))
                throw new NonComparableElementException("DoubleOrderedList");

            Comparable<T> comparableElement = (Comparable<T>)element;

            DoubleNode<T> current = head;
            DoubleNode<T> newNode  = new DoubleNode<T>(element);

            boolean found = false;

            if (isEmpty())  // list is empty
            {
                head = newNode;
                tail = newNode;
            }
            else if (comparableElement.compareTo(head.getElement()) <= 0)
            // element goes in front
            {

                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
            }
            else if (comparableElement.compareTo(tail.getElement()) >= 0)
            // element goes at tail
            {
                tail.setNext(newNode);
                newNode.setPrevious(tail);
                tail = newNode;
            }
            else  // element goes in the middle
            {
                while ((comparableElement.compareTo(current.getElement()) > 0))
                {
                    current = current.getNext();
                }

                current.getPrevious().setNext(newNode);
                newNode.setPrevious(current.getPrevious());

                newNode.setNext(current);
                current.setPrevious(newNode);


            }

            count++;
            modCount++;
        }

    }
}

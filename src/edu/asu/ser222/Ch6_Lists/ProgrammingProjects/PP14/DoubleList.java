package edu.asu.ser222.Ch6_Lists.ProgrammingProjects.PP14;

import edu.asu.ser222.Ch6_Lists.ProgrammingProjects.exceptions.ElementNotFoundException;
import edu.asu.ser222.Ch6_Lists.ProgrammingProjects.exceptions.EmptyCollectionException;
import sun.invoke.empty.Empty;

import java.util.*;

/**
 * Created by HM on 3/12/16.
 */
public abstract class DoubleList<T>  implements DoubleListADT<T>, Iterable<T> {


    protected int count;
    protected DoubleNode<T> head, tail;
    protected int modCount;


    /**
     * Creates an empty list.
     */
    public DoubleList(){

        count = 0;
        modCount = 0;
        head = tail = null;

    }



    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    public T removeFirst() throws EmptyCollectionException {

        if(isEmpty()){
            throw new EmptyCollectionException("DoubleList");
        }

        DoubleNode<T> result = head;
        head = head.getNext();
        if(head==null)
            tail=null;
        count--;
        modCount++;

        return result.getElement();
    }

    /**
     * Removes the last element in this list and
     * returns a reference to it.
     * If the list is empty it throws an EmptyCollectionException
     *
     * @return the last element from this list
     * @throws EmptyCollectionException if the list is empty.
     */
    public T removeLast() throws EmptyCollectionException {

        if(isEmpty())
            throw  new EmptyCollectionException("DoubleList");

        DoubleNode<T> last  = tail;
        tail = tail.getPrevious();

        if (tail==null) // only one element in the list
            head = null;
        else
            tail.setNext(null);

        count--;
        modCount++;

        return last.getElement();

    }


    /**
     *  Removes the first instance of the specified element from this
     * list and returns a reference to it.
     * Throws an EmptyCollectionException
     * if the list is empty.
     * Throws a ElementNotFoundException if the
     * specified element is not found in the list.
     *
     * @param  targetElement the element to be removed from the list
     * @return a reference to the removed element
     * @throws EmptyCollectionException if the list is empty
     * @throws ElementNotFoundException if the target element is not found
     */
    public T remove(T targetElement) throws EmptyCollectionException, ElementNotFoundException {


        if(isEmpty())
            throw  new EmptyCollectionException("DoubleList");


        boolean found  = false;

        DoubleNode<T> current = head;

        while(current != null && !found){

            if(targetElement.equals(current.getElement())){
                found = true;
            }
            else
                current = current.getNext();
        }


        if(!found)
            throw new ElementNotFoundException("DoubleList");


        if(size() ==1)  // only one element in the list
            head = tail = null;
        else if(current.equals(head)){   //target is at head
            head = head.getNext();
            head.setPrevious(null);
        }
        else if(current.equals(tail)){  // target is at the tail
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        else{   // target is somewhere in the middle
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
        }


        count--;
        modCount++;

        return current.getElement();

    }

    /**
     * Returns the first element in this list without removing it.
     *
     * @return the first element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T first() throws EmptyCollectionException {

        if(isEmpty())
            throw new EmptyCollectionException("DoubleList");

        return head.getElement();
    }

    /**
     /**
     * Returns the last element in this list without removing it.
     *
     * @return the last element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T last() throws EmptyCollectionException {

        if(isEmpty())
            throw new EmptyCollectionException("DoubleList");

        return tail.getElement();
    }


    /**
     * Returns true if the specified element is found in this list and
     * false otherwise. Throws an EmptyCollectionException if the list
     * is empty.
     *
     * @param  targetElement the element that is sought in the list
     * @return true if the element is found in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public boolean contains(T targetElement) throws EmptyCollectionException {


        if(isEmpty())
            throw new EmptyCollectionException("DoubleList");

        boolean found = false;

        DoubleNode<T>  current = head;

        while(current != null && !found){

            if(targetElement.equals(current.getElement())){
                found = true;
            }
            else
                current = current.getNext();

        }

        return found;

    }


    /**
     * Returns true if this list is empty and false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()  {

        return (count == 0);
    }


    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in the list
     */
    public int size() {

        return count;
    }


    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of the list
     */
    public String toString()
    {

        DoubleNode<T> current = head;
        String result = "";

        while(current!=null){
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;


    }


    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements of the list
     */
    public Iterator<T> iterator()
    {
        return new DoubleListIterator();
    }


    /**
     * LinkedIterator represents an iterator for a linked list of linear nodes.
     */
    private class DoubleListIterator implements Iterator<T>
    {
        private int iteratorModCount;   // the number of elements in the collection
        private DoubleNode<T> current;  // the current position

        /**
         * Sets up this iterator using the specified items.
         *
         * @param collection  the collection the iterator will move over
         * @param size        the integer size of the collection
         */
        public DoubleListIterator()
        {
            current = head;
            iteratorModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (iteratorModCount != modCount)
                throw new ConcurrentModificationException();

            return (current != null);
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws ConcurrentModificationException
        {
            if (!hasNext())
                throw new NoSuchElementException();

            T result = current.getElement();
            current = current.getNext();
            return result;
        }

        /**
         * The remove operation is not supported.
         *
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
    }








}

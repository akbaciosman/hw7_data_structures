/*
 *Costumer leri tutmak için olusturduğumuz Queue
 */
package com.mycompany.hw7_111044054;

import java.util.LinkedList;

/**
 *
 * @author osman
 */
public class Queue<E> implements QueueInt<E>{
    private LinkedList<E> theQueue = new LinkedList<E>();

    /**
     * 
     * @param obj
     * @return verilen elemani Queue un sonuna ekler 
     */
    @Override
    public E offer(E obj) {
        theQueue.addLast(obj);
        return obj;
    }

    /**
     * Queue nun başından eleman ceker,ilk elemani siler
     * @return 
     */
    @Override
    public E poll() {
        if(theQueue.size()==0)
            return null;
        else
            return theQueue.remove(0);
    }

    /**
     * ilk elemani silmeden alir
     * @return 
     */
    @Override
    public E peek() {
        if(theQueue.size()==0)
            return null;
        else
            return theQueue.getFirst();
    }
    
    /**
     * Son elemani alir
     * @return 
     */
    public E getLast(){
        return theQueue.pollLast(); 
    }
    
    /**
     * Queue nun basina eleman ekler
     * @param obj
     * @return 
     */
    public E addFirst(E obj){
        theQueue.addFirst(obj);
        return obj;
    }
    
    
    /**
     * verilen Queue nun size ni dondurur
     * @return 
     */
    public int  size(){
        return theQueue.size();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw7_111044054;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *  Elemanlari sıralarken bir Stack e ihtiyacim olduğu için olusturdum
 * @author osman
 */
public class ArrayStack<E> implements StackInt<E>{
    E[] theData;
    int topOfStack = -1;
    private static final int INITIAL_CAPACITY=10;
    public ArrayStack(){theData = (E[])new Object[INITIAL_CAPACITY];}
    
 

    @Override
    public E push(E obj) {
        if(topOfStack==theData.length-1){
               reallocate();
        }
        topOfStack++;
        theData[topOfStack] = obj;
        return obj;
    }
    
    public void reallocate(){
        int i=0;
        ArrayList tempArray = new ArrayList(); 
        while(theData.length!=0){
            tempArray.add(theData[i]);
            i++;
        }
        theData = (E[])new ArrayStack[theData.length*2];
        i=0;
        int size = tempArray.size();
        while(size != i){
            theData[i] = (E)tempArray.get(i);
            i++;
        }
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        
        return theData[topOfStack--];
    }

    @Override
    public boolean isEmpty() {
        if(topOfStack==-1)
            return true;
        else
            return false;
    }
    
}

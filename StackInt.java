/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw7_111044054;

/**
 *
 * @author osman
 */
public interface StackInt<E> {
    E push(E obj);
    E pop();
    boolean isEmpty();
}

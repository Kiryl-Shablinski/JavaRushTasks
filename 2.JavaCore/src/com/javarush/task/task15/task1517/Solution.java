package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

public class Solution {
    public static int A=0;

    static {
        //throw an exception here - выбросьте эксепшн тут
      A/=0;
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}

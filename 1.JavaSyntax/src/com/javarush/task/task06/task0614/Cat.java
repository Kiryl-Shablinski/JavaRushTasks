package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код

    public  static ArrayList<Cat> cats=new ArrayList<>(10);

   public Cat(String name){}


    public static void main(String[] args) {
        for (int i=0; i<cats.size(); i++) {
            cats.add(new Cat("Vaska"+i));
            //напишите тут ваш код
        }
            printCats();

    }

    public static void printCats() {
        for (int i = 0; i < cats.size(); i++){
            System.out.println(cats.get(i));
    }
        //напишите тут ваш код
    }
}

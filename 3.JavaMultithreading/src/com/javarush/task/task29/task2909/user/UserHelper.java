package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

   /*14..1
    private boolean isManAnya = false;
    private boolean isManRoma = true;

    */

    public void printUsers() {
     /*13..2
        System.out.println("Имя: " + userAnya.getName());
        System.out.println("Фамилия: " + userAnya.getSurname());

      */
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

       /*
        System.out.println("Имя: " + userRoma.getName());
        System.out.println("Фамилия: " + userRoma.getSurname());
       */
        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

   /* 13..4
    public void printAdditionalInfo(User user) {
        if (ageLessThan16(user))
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }
    */

   /*13..3
    private boolean ageLessThan16(User user) {

        if (user.getAge() < 16) {
            return true;
        }
        return false;
    }
    */
//13..5
    public int calculateAverageAge() {
      //  int age = 28;
        User userUra = new User("Юра", "Карп", 28 /*age*/);

         return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;


    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
      /*13..6
       base.set(base.get() + age / 100);
        base.set((int) (base.get() * (hasWork ? 1.1 : 0.9)));
        base.set((int) (base.get() * (hasHouse ? 1.1 : 0.9)));
      */
        return (int)((base.get()+age/100) * (hasWork ? 1.1 : 0.9) * (hasHouse ? 1.1 : 0.9));
    }

    public String getBossName(User user) {
    //14..8
       // Work work = user.getWork();
        return user.getBoss();
    }
}
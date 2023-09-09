package de.geekteck.les5.general;

import de.geekteck.les5.obj.Car;
import de.geekteck.les5.obj.Chair;

public class Main {
    public static void main(String[] args) {
        Car carAudi = new Car();
        carAudi.model = "A8";
        carAudi.year = 2002;
        carAudi.volume = 3.3;

        Car c2 = new Car();
        c2.volume = 2.1;
        c2.year = 2000;
        c2.model = "C3";

        Car mashina = new Car(2020, 3.5, "Jip");
        System.out.println(carAudi.model+" "+carAudi.volume+" "+carAudi.year);
        System.out.println(c2.model+" "+c2.volume+" "+c2.year);
        mashina.makeBeep();
        mashina.makeBeep("yiiiiiii");

        System.out.println(mashina.model+" "+mashina.volume+" "+mashina.year);

        Chair chair = new Chair("Koja", 60);
        System.out.println(chair.getHeight()+" " +chair.getMaterial());
        chair.setHeight(-90);
        System.out.println(chair.getMaterial()+" "+chair.getHeight());
        mashina.setChair(chair);
        System.out.println(mashina.model+" "+mashina.volume+" "+mashina.year+" "+
                " Info o kresle "+mashina.getChair().getHeight()+" "+mashina.getChair().getMaterial());

    }
}
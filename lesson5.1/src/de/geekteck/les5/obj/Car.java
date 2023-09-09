package de.geekteck.les5.obj;

public class Car {
    public int year;
    public double volume;
    public String model;

    private Chair chair;

    public Car(){}

    public Car(int year, double vol, String model){
        this.year = year;
        volume = vol;
        this.model = model;
    }

    public void makeBeep(){
        System.out.println("Beep");
    }
    public void makeBeep(String voice){
        System.out.println(voice);
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}

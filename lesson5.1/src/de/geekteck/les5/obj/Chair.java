package de.geekteck.les5.obj;

public class Chair {
    private String material;
    private int height;

    public Chair(String material, int height) {
        this.material = material;
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height<=0){
            System.out.println("wrong value!");
        }
        else {
            this.height = height;
        }
    }
}

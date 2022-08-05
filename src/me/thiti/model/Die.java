package me.thiti.model;

public class Die {
    private int faceValue;

    public void roll() {
        faceValue = (int)(1 + (Math.random() * 100) % 6);
    }

    public int getFaceValue() {
        return faceValue;
    }
}

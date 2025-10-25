package com.sheetlab.desktop.utils;

public class Cords {
    private double x, y;
    public Cords(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Cords() {
        x = 0;
        y = 0;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
package com.elevator;

public class Request {
    private int direction;
    private int floorNumber;

    public Request(int direction, int floorNumber) {
        this.direction = direction;
        this.floorNumber = floorNumber;
    }

    public int getDirection() {
        return direction;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}

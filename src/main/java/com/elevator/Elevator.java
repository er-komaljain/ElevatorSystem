package com.elevator;

public class Elevator {
    private int totalFloors ;
    private int currentFloor;
    private int currentDirection;

    public Elevator(int totalFloors, int currentFloor) {
        this.totalFloors = totalFloors;
        this.currentFloor = currentFloor;
    }

    public void callElevator(int direction, int floorNumber) throws Exception {
        if(direction == 1) {
            moveUp(floorNumber);
        } else {
            moveDown(floorNumber);
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    private void moveUp(int floorNumber) throws Exception {
        if(floorNumber > totalFloors) {
            throw new Exception("This floor does not exist. Use anything between 0 to 10");
        }
        int increment = floorNumber - currentFloor;
        this.currentFloor += increment;
    }

    private void moveDown(int floorNumber) throws Exception {
        if(floorNumber < 0) {
            throw new Exception("This floor does not exist. Use anything between 0 to 10");
        }
        int decrement = this.currentFloor - floorNumber;
        this.currentFloor -=decrement;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}

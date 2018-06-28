package com.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class ElevatorManager {
    private List<Request> upRequests; //Use SortedSet instead
    private List<Request> downRequest; //Use SortedSet instead
    private Elevator elevator;

    public ElevatorManager(Elevator elevator) {
        this.elevator = elevator;
        this.upRequests = new ArrayList<Request>();
        this.downRequest = new ArrayList<Request>();
    }

    public void callElevator(Request request) {
        if(request.getDirection() == 1) {
            this.upRequests.add(request);
        } else {
            this.downRequest.add(request);
        }
    }

    public void nextStop() throws Exception {
        if (elevator.getCurrentDirection() == 1) {
            this.upRequests.stream().forEach( (upRequest) -> {
                try {
                    elevator.callElevator(1, upRequest.getFloorNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        //DO similar for when elevator is going down or is at halt
    }
}

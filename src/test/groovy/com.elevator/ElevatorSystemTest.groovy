package com.elevator

import spock.lang.Specification

class ElevatorSystemTest extends Specification {

    def "should be able to call a elevator from floor 5 to floor 0"() {
        given:
        def currentFloor = 5
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = 0
        def direction = -1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        elevator.getCurrentFloor() == 0
    }

    def "should be able to call a elevator from floor 5 to floor 5"() {
        given:
        def currentFloor = 5
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = 5
        def direction = -1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        elevator.getCurrentFloor() == 5
    }

    def "should be able to call a elevator from floor 3 to floor 5"() {
        given:
        def currentFloor = 3
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = 5
        def direction = 1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        elevator.getCurrentFloor() == 5
    }


    def "should be able to move up to floor 7"() {
        given:
        def currentFloor = 0
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = 7
        def direction = 1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        elevator.getCurrentFloor() == 7
    }

    def "should be able to move up to floor 7 from floor 4"() {
        given:
        def currentFloor = 4
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = 7
        def direction = 1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        elevator.getCurrentFloor() == 7
    }

    def "should be able to move up to floor 11 from floor 4"() {
        given:
        def currentFloor = 4
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = 11
        def direction = 1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        thrown(Exception)
        elevator.getCurrentFloor() == 4
    }

    def "should be able to move down from floor 9 to floor 3"() {
        given:
        def currentFloor = 9
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = 3
        def direction = -1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        elevator.getCurrentFloor() == 3
    }

    def "should be able to move down from floor 9 to floor -1"() {
        given:
        def currentFloor = 9
        def totalFloors = 10
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        def floorNumber = -1
        def direction = -1

        when:
        elevator.callElevator(direction, floorNumber)

        then:
        thrown(Exception)
        elevator.getCurrentFloor() == 9
    }

    def "elevator moving up to floor 5 is called from floor 0"() {
        given:
        def currentFloor = 1
        def totalFloors = 10
        def currentDirection = 1
        Elevator elevator = new Elevator(totalFloors, currentFloor)
        ElevatorManager manager = new ElevatorManager(elevator)
        Request request1 = new Request(1, 5)
        Request request2 = new Request(-1, 0)

        manager.callElevator(request1)

        when:
        manager.callElevator(request2)

        then:
        elevator.getCurrentFloor() == 0
    }


}

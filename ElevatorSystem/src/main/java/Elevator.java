class Elevator {
    private final String elevatorTitle;
    private int currentFloor;

    public Elevator(String elevatorTitle, int currentFloor) {
        this.elevatorTitle = elevatorTitle;
        this.currentFloor = currentFloor;
    }

    public String getElevatorTitle() {
        return elevatorTitle;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToFloor(int floor) {
        System.out.println(elevatorTitle + " движется на этаж " + floor);
        this.currentFloor = floor;
    }
}


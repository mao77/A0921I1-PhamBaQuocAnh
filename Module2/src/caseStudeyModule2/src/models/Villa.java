package models;

public class Villa extends Facility{
    private String roomStandard;
    private String poolArea;
    private String numberOfFloors;

    public Villa() {
    }

    public Villa(String name, String useArea, String costRent, String maximumOfNumberPeople, String rentType,
                 String roomStandard, String poolArea, String numberOfFloors) {
        super(name, useArea, costRent, maximumOfNumberPeople, rentType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "name='" + name + '\'' +
                ", useArea='" + useArea + '\'' +
                ", costRent='" + costRent + '\'' +
                ", maximumOfNumberPeople='" + maximumOfNumberPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\'' +
                '}';
    }
    public String getInfoToCSV(){
        return this.name+","+this.useArea+","+this.costRent+","+this.maximumOfNumberPeople+","+
                this.rentType+","+this.roomStandard+","+this.poolArea+","+this.numberOfFloors;
    }
}

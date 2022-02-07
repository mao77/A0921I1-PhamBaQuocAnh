package models;

public class House extends Facility{
    private String roomStandard;
    private String numberOfFloors;

    public House() {
    }

    public House(String name, String useArea, String costRent, String maximumOfNumberPeople,
                 String rentType, String roomStandard, String numberOfFloors) {
        super(name, useArea, costRent, maximumOfNumberPeople, rentType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", useArea='" + useArea + '\'' +
                ", costRent='" + costRent + '\'' +
                ", maximumOfNumberPeople='" + maximumOfNumberPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\'' +
                '}';
    }
    public String getInfoToCSV(){
        return this.name+","+this.useArea+","+this.costRent+","+this.maximumOfNumberPeople+","+
                this.rentType+","+this.roomStandard+","+this.numberOfFloors;
    }
}

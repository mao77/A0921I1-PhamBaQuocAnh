package models;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String name, String useArea, String costRent, String maximumOfNumberPeople, String rentType, String freeService) {
        super(name, useArea, costRent, maximumOfNumberPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", useArea='" + useArea + '\'' +
                ", costRent='" + costRent + '\'' +
                ", maximumOfNumberPeople='" + maximumOfNumberPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }
    public String getInfoToCSV(){
        return this.name+","+this.useArea+","+this.costRent+","+this.maximumOfNumberPeople+","+
                this.rentType+","+this.freeService;
    }
}

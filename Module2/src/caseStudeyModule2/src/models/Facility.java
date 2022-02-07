package models;

public abstract class Facility {
    protected String name;
    protected String useArea;
    protected String costRent;
    protected String maximumOfNumberPeople;
    protected String rentType;

    public Facility() {
    }

    public Facility(String name, String useArea, String costRent, String maximumOfNumberPeople, String rentType) {
        this.name = name;
        this.useArea = useArea;
        this.costRent = costRent;
        this.maximumOfNumberPeople = maximumOfNumberPeople;
        this.rentType = rentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUseArea() {
        return useArea;
    }

    public void setUseArea(String useArea) {
        this.useArea = useArea;
    }

    public String getCostRent() {
        return costRent;
    }

    public void setCostRent(String costRent) {
        this.costRent = costRent;
    }

    public String getMaximumOfNumberPeople() {
        return maximumOfNumberPeople;
    }

    public void setMaximumOfNumberPeople(String maximumOfNumberPeople) {
        this.maximumOfNumberPeople = maximumOfNumberPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", useArea='" + useArea + '\'' +
                ", costRent='" + costRent + '\'' +
                ", maximumOfNumberPeople='" + maximumOfNumberPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                '}';
    }

}

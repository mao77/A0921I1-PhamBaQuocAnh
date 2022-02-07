package models;

public class Customer extends Person{
    private String customerID;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, String birthDay, String gender, String phoneNumber,
                    String passportNumber, String email, String customerID, String customerType, String address) {
        super(name, birthDay, gender, phoneNumber, passportNumber, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", email='" + email + '\'' +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public String getInfoToCSV(){
        return this.customerID+","+this.name+","+this.birthDay+","+this.gender+","+this.phoneNumber+","+
                this.passportNumber+","+this.email+","+this.customerType+","+this.address;
    }
}

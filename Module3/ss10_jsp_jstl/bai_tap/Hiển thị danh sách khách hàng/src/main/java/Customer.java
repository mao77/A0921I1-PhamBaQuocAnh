public class Customer {
    String name;
    String birthDay;
    String address;

    public Customer(String name, String birthDay, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
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
                "name=" + name +
                ", birthDay=" + birthDay +
                ", address=" + address +
                '}';
    }
}

package models;

public class Employee extends Person{
    private String employeeID;
    private String level;
    private String position;
    private String salary;

    public Employee() {
    }

    public Employee(String name, String birthDay, String gender, String phoneNumber, String passportNumber,
                    String email, String employeeID, String level, String position, String salary) {
        super(name, birthDay, gender, phoneNumber, passportNumber, email);
        this.employeeID = employeeID;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", email='" + email + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
    public String getInfoToCSV(){
        return this.employeeID+","+this.name+","+this.birthDay+","+this.gender+","+this.phoneNumber+
                ","+this.passportNumber+","+this.email+","+this.level+","+this.position+","+this.salary;
    }
}

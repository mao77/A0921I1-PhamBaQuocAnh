package models;

public class Booking {
    private String bookingID;
    private String startDay;
    private String endDay;
    private Customer customer;
    private Facility facility;

    public Booking(String bookingID, String startDay, String endDay, Customer customer, Facility facility) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customer = customer;
        this.facility = facility;
    }

    public Booking() {
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customer=" + customer + '\n' +
                ", facility=" + facility + '\n' +
                '}';
    }
    public String getInfoToCSV(){
        return this.bookingID+","+this.startDay+","+this.endDay+","+this.customer.getCustomerID()+","+this.facility.getName();
    }
}

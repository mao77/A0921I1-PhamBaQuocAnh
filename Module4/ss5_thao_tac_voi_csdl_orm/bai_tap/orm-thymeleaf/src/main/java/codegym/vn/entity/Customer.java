package vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id", columnDefinition = "varchar(10)")
    int id;
    @Column(name = "customer_name")
    String name;
    @Column(name = "customer_gender")
    boolean sex;
    @Column(name = "customer_email",columnDefinition = "varchar(45)")
    String email;
    @Column(name = "customer_address",columnDefinition = "varchar(45)")
    String address;

    public Customer() {
    }

    public Customer(int id, String name, boolean sex, String email, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

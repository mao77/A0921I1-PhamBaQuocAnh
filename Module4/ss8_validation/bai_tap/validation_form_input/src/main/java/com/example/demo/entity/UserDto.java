package com.example.demo.entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDto{
    private int id;

    @NotBlank(message = "k dc de khoang trang")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$",
                    message = "ten khong dung dinh dang")
    private String firstName;

    @NotBlank(message = "k dc de khoang trang")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$",
                    message = "ten khong dung dinh dang")
    private String lastName;

    @NotBlank(message = "k dc de khoang trang")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "so phone khong dung dinh dang")
    private String phoneNumber;

    @NotBlank(message = "k dc de khoang trang")
    @Min(value = 18,message = "tuoi phai tren 18")
    private String age;

    @NotBlank(message = "k dc de khoang trang")
    @Email
//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
//                        message = "email khong dung dinh dang")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

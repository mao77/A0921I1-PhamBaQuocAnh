package ss17_io_binary_file_serialization.thuc_hanh.doc_va_ghi_danh_sach_sinh_vien_ra_file_nhi_phan;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String adress;

    public Student() {
    }

    public Student(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}

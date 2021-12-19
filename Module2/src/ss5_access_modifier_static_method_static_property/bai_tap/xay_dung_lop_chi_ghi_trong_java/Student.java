package ss5_access_modifier_static_method_static_property.bai_tap.xay_dung_lop_chi_ghi_trong_java;

public class Student {
    private String name = "John";
    private String classes = "C02";

    Student () {

    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}

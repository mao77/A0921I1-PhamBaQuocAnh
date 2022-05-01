package codegym.vn.entity;

public class MedicalDeclaration {
    int id;
    String name;
    boolean sex;
    String country;
    String passport;
    String[] travelInformation;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(int id, String name, boolean sex, String country, String passport, String[] travelInformation) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.country = country;
        this.passport = passport;
        this.travelInformation = travelInformation;
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

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String[] getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String[] travelInformation) {
        this.travelInformation = travelInformation;
    }

    @Override
    public String toString() {
        return "MedicalDeclaration{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", passport='" + passport + '\'' +
                ", travelInformation='" + travelInformation + '\'' +
                '}';
    }
}

package model.bean;

public class Division {
    int id;
    String name;

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Division() {
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
}

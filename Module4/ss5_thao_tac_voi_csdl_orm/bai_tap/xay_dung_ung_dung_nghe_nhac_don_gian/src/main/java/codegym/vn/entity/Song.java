package codegym.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @Column(name = "song_id",columnDefinition = "varchar(50)")
    private String id;
    @Column(name = "song_name")
    private String name;
    @Column(name = "song_type")
    private String type;
    @Column(name = "song_link")
    private String link;

    public Song() {
    }

    public Song(String id, String name, String type, String link) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

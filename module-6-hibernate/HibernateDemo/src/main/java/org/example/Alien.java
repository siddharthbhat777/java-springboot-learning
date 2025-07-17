package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "alien_table") // change table name
public class Alien {
    @Id
    private int alienId;
    @Column(name = "a_name") // changes column name
    private String alienName;
    @Transient // helps to exclude variables which should not be added to database but need for code operations
    private String technology;

    public int getAlienId() {
        return alienId;
    }

    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }

    public String getAlienName() {
        return alienName;
    }

    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "alienId=" + alienId +
                ", alienName='" + alienName + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}

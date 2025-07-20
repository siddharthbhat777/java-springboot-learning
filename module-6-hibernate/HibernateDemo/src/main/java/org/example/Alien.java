package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {
    @Id
    private int alienId;
    private String alienName;
    private String technology;
    @OneToMany(mappedBy = "alien") // alien is name of variable in Laptop model
    private List<Laptop> laptops;

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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "alienId=" + alienId +
                ", alienName='" + alienName + '\'' +
                ", technology='" + technology + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}

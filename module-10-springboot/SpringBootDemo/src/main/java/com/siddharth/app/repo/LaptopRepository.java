package com.siddharth.app.repo;

import com.siddharth.app.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save(Laptop lap) {
        System.out.println("Saved in database...");
    }
}
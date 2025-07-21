package com.siddharth.app;

import org.springframework.stereotype.Component;

@Component // Notifying spring that it needs to manage this class's object
public class Alien {
    public void code() {
        System.out.println("Coding...");
    }
}

package com.vamsi.examples.AllExamples.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ObjectLock {

    @Id
    int id;
    float balance;
    String name;

    public ObjectLock() {
    }

    public ObjectLock(int id, float balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

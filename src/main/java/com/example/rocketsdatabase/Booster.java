package com.example.rocketsdatabase;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity(name = "boosters")
public class Booster {

    @Id
    private String Id= UUID.randomUUID().toString();

    public static final int STEP_POWER_BOOSTER = 10;
    public int maxBoosterPower;
    public int currentBoosterPower = 0;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rocket_id")
    @JsonBackReference
    private Rocket rocket;

    public Booster(){
    }

    public Booster(int maxBoosterPower) throws Exception {
        checkMaxBoosterPower(maxBoosterPower);
        this.maxBoosterPower = maxBoosterPower;
    }

    public Booster(Rocket rocket) { this.rocket = rocket; }

    private void checkMaxBoosterPower(int maxBoosterPower) throws Exception {
        if (maxBoosterPower < 0)
            throw new Exception("La potencia d'un propulsor ha de ser un número enter positiu.");
    }

    public int getMaxBoosterPower() { return maxBoosterPower; }

    public int getCurrentBoosterPower() { return currentBoosterPower; }

    public void setMaxBoosterPower(int maxBoosterPower) throws Exception {
        checkMaxBoosterPower(maxBoosterPower);
        this.maxBoosterPower = maxBoosterPower;
    }

    public String getId() { return Id; }

    public Rocket getRocket() { return rocket; }

    public void setRocket(Rocket rocket) { this.rocket = rocket; }

    public void increasePower() {
        currentBoosterPower += STEP_POWER_BOOSTER;
        if (currentBoosterPower > maxBoosterPower) {
            currentBoosterPower = maxBoosterPower;
        }
    }

    public void decreasePower() {
        this.currentBoosterPower -= STEP_POWER_BOOSTER;
        if (currentBoosterPower < 0) {
            currentBoosterPower = 0;
        }
    }
}





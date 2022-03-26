package com.example.rocketsdatabase;


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
    private String id= UUID.randomUUID().toString();

    public final  int STEP_POWER_BOOSTER = 10;
    public int maxPowerBooster;
    public int currentPowerBooster = 0;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rocket_id")
    private Rocket rocket;

    public Booster(){
    }

    public Booster(int maxPowerBooster) throws Exception {
        checkPowerBooster(maxPowerBooster);
        this.maxPowerBooster = maxPowerBooster;
    }

    public Booster(Rocket rocket) { this.rocket = rocket; }

    private void checkPowerBooster(int maxPowerBooster) throws Exception {
        if (maxPowerBooster < 0)
            throw new Exception("La potencia d'un propulsor ha de ser un número enter positiu.");
    }

    public int getMaxPowerBooster() { return maxPowerBooster; }

    public int getCurrentPowerBooster() { return currentPowerBooster; }

    public void setMaxPowerBooster(int maxPowerBooster) throws Exception {
        checkPowerBooster(maxPowerBooster);
        this.maxPowerBooster = maxPowerBooster;
    }

    public String getId() { return id; }

    public Rocket getRocket() { return rocket; }

    public void setRocket(Rocket rocket) { this.rocket = rocket; }

    public void increasePower() {
        currentPowerBooster += STEP_POWER_BOOSTER;
        if (this.currentPowerBooster > maxPowerBooster) {
            currentPowerBooster = maxPowerBooster;
        }
    }

    public void decreasePower() {
        this.currentPowerBooster =- STEP_POWER_BOOSTER;
        if (this.currentPowerBooster< 0) {
            this.currentPowerBooster = 0;
        }
    }
}





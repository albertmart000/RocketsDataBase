package com.example.rocketsdatabase;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "rockets")
public class Rocket {

    @javax.persistence.Id
    private String Id= UUID.randomUUID().toString();

    private String rocketCode;
    private int currentRocketPower;
    private int maxRocketPower;

    @OneToMany(mappedBy = "rocket")
    private List<Booster> boosterList = new ArrayList<>();

    public Rocket(){
    }

    public Rocket(String rocketCode) throws Exception {
        checkRocketCode(rocketCode);
        this.rocketCode = rocketCode;

    }
    private void checkRocketCode(String rocketCode) throws Exception {
        if (!(rocketCode.matches("^[0-9]{2}[A-Z]{6}$") || rocketCode.matches("^[A-Z]{6}[0-9]{2}$")))
            throw new Exception("El format del codi no es correcte.");
    }

    public String getId() { return Id; }


    public String getRocketCode() { return rocketCode; }

    public void setRocketCode(String rocketCode) throws Exception {
        checkRocketCode(rocketCode);
        this.rocketCode = rocketCode;
    }

    public List<Booster> getBoosterList() { return boosterList; }

    public void setBoosterList(List<Booster> boosterList) {
        this.boosterList = boosterList;
    }

    public int getCurrentRocketPower() {
        int currentRocketPower = 0;
        for (Booster booster: boosterList) {
            currentRocketPower += booster.getCurrentPowerBooster();
        }
        return currentRocketPower;
    }

    public void increasePowerRocket (){
        for (Booster booster: boosterList) {
            booster.increasePower();
        }
    }

    public void decreasePowerRocket (){
        for (Booster booster: boosterList) {
            booster.decreasePower();
        }
    }
}



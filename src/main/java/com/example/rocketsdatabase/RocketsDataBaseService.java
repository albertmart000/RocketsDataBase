package com.example.rocketsdatabase;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RocketsDataBaseService {

    private RocketRepository rocketRepository;
    private BoosterRepository boosterRepository;

    public RocketsDataBaseService(RocketRepository rocketRepository,
                                  BoosterRepository boosterRepository) {
        this.rocketRepository = rocketRepository;
        this.boosterRepository = boosterRepository;
    }

    public Rocket createRocket(Rocket rocketToCreate) {
        this.rocketRepository.save(rocketToCreate);
        return rocketToCreate;
    }

    public List<Rocket> getRockets() {
        List<Rocket> rockets = new ArrayList<>();
        this.rocketRepository.findAll().forEach(rockets::add);
        return rockets;
    }

    public void removeAllRockets() {
        this.rocketRepository.deleteAll();
    }

    public Rocket updateRocket(Rocket rocketToUpdate, String rocketId) throws Exception {
        Rocket rocket = rocketRepository.findById(rocketId).get();
        rocket.setRocketCode(rocketToUpdate.getRocketCode());
        rocketRepository.save(rocket);
        return rocket;
    }

    public Rocket getRocket(String rocketId) {
        return this.rocketRepository.findById(rocketId).get();
    }

    public void removeRocket(String rocketId) {
        this.rocketRepository.deleteById(rocketId);
    }

    public void addBoosterOnRocket(String rocketId, int maxPowerBooster) throws Exception {
        Rocket rocket = rocketRepository.findById(rocketId).get();
        List<Booster> boosters = rocket.addBooster(maxPowerBooster);
        boosterRepository.saveAll(boosters);

    }

    public List<Booster> getBoosters(String rocketId) {
        Rocket rocket = searchRocket(rocketId);
        return rocket.getBoosterList();
    }

    public void removeAllBoosters(String rocketId) {
        Rocket rocket = searchRocket(rocketId);
        boosterRepository.deleteAllByRocket(rocket);
    }

    public Booster getBooster(String rocketId, String boosterId) {
        return boosterRepository.findById(boosterId).get();
    }

    public void removeBooster(String rocketId, String boosterId) {
        this.boosterRepository.deleteById(boosterId);
    }

    private Rocket searchRocket(String rocketId) {
        return rocketRepository.findById(rocketId).get();
    }

    public Booster updateBooster(Booster boosterToUpdate, String rocketId, String boosterId) throws Exception {
        Rocket rocket = rocketRepository.findById(rocketId).get();
        Booster booster = boosterRepository.findById(boosterId).get();
        booster.setMaxPowerBooster(boosterToUpdate.getMaxPowerBooster());
        rocketRepository.save(rocket);
        return booster;
    }
}





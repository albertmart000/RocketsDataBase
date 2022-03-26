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

    public Rocket createRocket(Rocket rocketToCreate){
        this.rocketRepository.save(rocketToCreate);
        return rocketToCreate;
    }

    public List<Rocket> getRockets() {
        List<Rocket> rockets = new ArrayList<>();
        this.rocketRepository.findAll().forEach(rockets::add);
        return rockets;
    }

    public void removeAllRockets() {this.rocketRepository.deleteAll();}
}

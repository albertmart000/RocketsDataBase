package com.example.rocketsdatabase;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RocketsDataBaseRestController {

    private RocketsDataBaseService rocketsDataBaseService;

    public RocketsDataBaseRestController(RocketsDataBaseService rocketsDataBaseService) {
        this.rocketsDataBaseService = rocketsDataBaseService;
    }

    @PostMapping("/rockets")
    public Rocket createRocket(@RequestBody Rocket rocketToCreate){
        return rocketsDataBaseService.createRocket(rocketToCreate);
    }

    @GetMapping("/rockets")
    public List<Rocket> getRockets() throws Exception {
        return rocketsDataBaseService.getRockets();
    }

    @DeleteMapping("/rockets")
    public void removeAllRockest() {
        rocketsDataBaseService.removeAllRockets();
    }

}

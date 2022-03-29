package com.example.rocketsdatabase;


import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RocketsDataBaseRestController {

    private RocketsDataBaseService rocketsDataBaseService;

    public RocketsDataBaseRestController(RocketsDataBaseService rocketsDataBaseService) {
        this.rocketsDataBaseService = rocketsDataBaseService;
    }

    @PostMapping("/rockets")
    public Rocket createRocket(@RequestBody Rocket rocketToCreate) {
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

    @PutMapping("/rockets/{rocketId}")
    public void updateRocket(@RequestBody Rocket rocketToUpdate,
                             @PathVariable String rocketId) throws Exception {
        rocketsDataBaseService.updateRocket(rocketToUpdate, rocketId);
    }

    @GetMapping("/rockets/{rocketId}")
    public Rocket getRocket(@PathVariable String rocketId) {
        return rocketsDataBaseService.getRocket(rocketId);
    }

    @DeleteMapping("/rockets/{rocketId}")

    public void removeRocket(@PathVariable String rocketId) {
        rocketsDataBaseService.removeRocket(rocketId);
    }

    @PostMapping("/rockets/{rocketId}/movement")
    public void moveRocket(@PathVariable String rocketId, @RequestBody String jsonString) throws Exception {
        JSONObject json = new JSONObject(jsonString);
        int numberStepsPowerBooster = json.getInt("numberStepsPowerBooster");
        rocketsDataBaseService.moveRocket(rocketId, numberStepsPowerBooster);
    }

    @PostMapping("/rockets/{rocketId}/boosters")
    public void addBooster(@PathVariable String rocketId, @RequestBody String jsonString) throws Exception {
        JSONObject json = new JSONObject(jsonString);
        int maxPowerBooster = json.getInt("maxPowerBooster");
        rocketsDataBaseService.addBoosterOnRocket(rocketId, maxPowerBooster);
    }

    @GetMapping("/rockets/{rocketId}/boosters")
    public List<Booster> getBoosters(@PathVariable String rocketId) {
        return rocketsDataBaseService.getBoosters(rocketId);
    }

    @DeleteMapping("/rockets/{rocketId}/boosters")
    public void removeAllBooster(@PathVariable String rocketId) {
        rocketsDataBaseService.removeAllBoosters(rocketId);
    }

    @PutMapping("/rockets/{rocketId}/boosters/{boosterId}")
    public void updateBooster(@RequestBody Booster boosterToUpdate,@PathVariable String rocketId,
                              @PathVariable String boosterId) throws Exception {
        rocketsDataBaseService.updateBooster(boosterToUpdate, rocketId, boosterId);
    }

    @GetMapping("/rockets/{rocketId}/boosters/{boosterId}")
    public Booster getBooster(@PathVariable String rocketId, @PathVariable String boosterId) {
        return rocketsDataBaseService.getBooster(rocketId, boosterId);
    }

    @DeleteMapping("/rockets/{rocketId}/boosters/{boosterId}")
    public void removeBooster(@PathVariable String rocketId, @PathVariable String boosterId) {
        rocketsDataBaseService.removeBooster(rocketId, boosterId);
    }

}



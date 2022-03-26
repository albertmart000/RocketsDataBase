package com.example.rocketsdatabase;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BoosterRepository extends CrudRepository <Booster, String> {
    @Transactional
    List<Booster> deleteAllByRocket (Rocket rocket);
}

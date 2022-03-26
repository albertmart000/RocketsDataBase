package com.example.rocketsdatabase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RocketRepository extends CrudRepository<Rocket, String> {
}

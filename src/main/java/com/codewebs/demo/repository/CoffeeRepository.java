package com.codewebs.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewebs.demo.model.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    Optional<Coffee> findByName(String name);

    Long deleteByName(String name);
}

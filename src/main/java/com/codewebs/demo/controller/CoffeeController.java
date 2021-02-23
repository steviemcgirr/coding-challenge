package com.codewebs.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewebs.demo.CoffeeService;
import com.codewebs.demo.model.CoffeeDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/coffee")
public class CoffeeController {

    private CoffeeService coffeeService;

    public CoffeeController(final CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/all")
    public List<CoffeeDto> getCoffees() {
        return coffeeService.getCoffees();
    }

    @GetMapping
    public CoffeeDto getCoffee(
            @RequestParam(name = "name") String name
    ) {
        return coffeeService.getCoffee(name);
    }

    @PostMapping
    public CoffeeDto addCoffee(
            @Validated @RequestBody CoffeeDto coffeeDto
    ) {
        return coffeeService.addCoffee(coffeeDto);
    }

    @PutMapping
    public CoffeeDto updateCoffee(
            @Validated @RequestBody CoffeeDto coffeeDto
    ) {
        return coffeeService.updateCoffee(coffeeDto);
    }

    @DeleteMapping
    public boolean deleteCoffee(
            @RequestParam(name = "name") String name
    ) {
        return coffeeService.deleteCoffee(name);
    }
}
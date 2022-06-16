package io.adomas.coffeshopv2.controllers;

import io.adomas.coffeshopv2.model.Coffee;
import io.adomas.coffeshopv2.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//TODO: prideti, kad cia butu /api/v1
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/coffees")
    public ResponseEntity<List<Coffee>> getAllCoffees() {
        return ResponseEntity.ok().body(coffeeService.getAllCoffees());
    }

    @PostMapping("/coffees")
    public ResponseEntity<Coffee> createCoffee(@RequestBody Coffee coffee) {
        return  ResponseEntity.ok().body(coffeeService.createCofee(coffee));
    }

    @PutMapping("/coffees/{coffeeId}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable int coffeeId, @RequestBody Coffee coffee) {
        coffee.setId(coffeeId);
        return ResponseEntity.ok().body(coffeeService.updateCoffee(coffee));
    }

    @DeleteMapping("/coffees/{coffeeId}")
    public HttpStatus deleteCoffee(@PathVariable int coffeeId) {
        coffeeService.deleteCoffee(coffeeId);
        return HttpStatus.OK;
    }

    @DeleteMapping("/coffees")
    public HttpStatus deleteCoffees() {
        coffeeService.deleteAllCoffees();
        return HttpStatus.OK;
    }

}

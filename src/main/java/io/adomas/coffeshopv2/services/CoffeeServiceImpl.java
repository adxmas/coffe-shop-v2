package io.adomas.coffeshopv2.services;

import io.adomas.coffeshopv2.exception.ResourceNotFoundException;
import io.adomas.coffeshopv2.model.Coffee;
import io.adomas.coffeshopv2.repository.CoffeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoffeeServiceImpl implements CoffeeService{

    @Autowired
    private CoffeeRepositary coffeeRepositary;

//    public CoffeeServiceImpl(CoffeeRepositary coffeeRepositary) {
//        this.coffeeRepositary = coffeeRepositary;
//    }

    @Override
    public Coffee createCofee(Coffee coffee) {
        return coffeeRepositary.save(coffee);
    }

    @Override
    public Coffee updateCoffee(Coffee coffee) {
        Optional<Coffee> coffeeDb = coffeeRepositary.findById(coffee.getId());

        if(coffeeDb.isPresent()) {
            Coffee coffeeUpdate = coffeeDb.get();

            coffeeUpdate.setId(coffee.getId());
            coffeeUpdate.setName(coffee.getName());
            coffeeUpdate.setDescription(coffee.getDescription());
            coffeeUpdate.setPrice(coffee.getPrice());

            coffeeRepositary.save(coffeeUpdate);
            return coffeeUpdate;
        } else {
            throw new ResourceNotFoundException("Resource was not found with id: " + coffee.getId());
        }
    }

    @Override
    public List<Coffee> getAllCoffees() {
        return coffeeRepositary.findAll();
    }

    @Override
    public Coffee getCofeeById(int coffeeId) {
        Optional<Coffee> coffeeDb = coffeeRepositary.findById(coffeeId);

        if(coffeeDb.isPresent()) {
            return coffeeDb.get();
        } else {
            throw new ResourceNotFoundException("Resource was not found with id: " + coffeeId);
        }
    }

    @Override
    public void deleteCoffee(int coffeeId) {
        Optional<Coffee> coffeeDb = coffeeRepositary.findById(coffeeId);

        if(coffeeDb.isPresent()) {
            coffeeRepositary.deleteById(coffeeId);
        } else {
            throw new ResourceNotFoundException("Resource was not found with id: " + coffeeId);
        }
    }

    @Override
    public void deleteAllCoffees() {
        coffeeRepositary.deleteAll();
    }


}

package io.adomas.coffeshopv2.repository;

import io.adomas.coffeshopv2.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepositary extends JpaRepository<Coffee, Integer> {



}

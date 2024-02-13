package com.example.Firstproject.repository;

import com.example.Firstproject.entity.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PizzaRepository extends CrudRepository<Pizza,Long> {
    @Override
    ArrayList<Pizza> findAll();
}

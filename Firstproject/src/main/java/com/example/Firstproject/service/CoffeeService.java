package com.example.Firstproject.service;

import com.example.Firstproject.dto.CoffeeForm;
import com.example.Firstproject.entity.Coffee;
import com.example.Firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;
    public ArrayList<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee show(long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee create(CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        if (coffee.getId() != null){
            return null;
        }
        return coffeeRepository.save(coffee);
    }

    public Coffee update(long id, CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        log.info("id: {}, coffee: {}",id,coffee.toString());

        Coffee target = coffeeRepository.findById(id).orElse(null);

        if (target == null || id != coffee.getId()){
            log.info("잘못된 요청! id: {},coffee: {}",id,coffee.toString());
            return null;
        }

        target.patch(coffee);
        return coffeeRepository.save(target);
    }

    public Coffee delete(long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if (target == null){
            return null;
        }
        coffeeRepository.delete(target);
        return target;
    }
}

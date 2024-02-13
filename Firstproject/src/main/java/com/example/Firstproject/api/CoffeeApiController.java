package com.example.Firstproject.api;

import com.example.Firstproject.dto.CoffeeForm;
import com.example.Firstproject.entity.Coffee;
import com.example.Firstproject.repository.CoffeeRepository;
import com.example.Firstproject.service.CoffeeService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeService coffeeService;
    private CoffeeRepository coffeeRepository;

    // GET
    @GetMapping("/api/coffee")
    public ArrayList<Coffee> index(){
        return coffeeService.index();
    }
    @GetMapping("/api/coffee/{id}")
    public Coffee show(@PathVariable long id){
        return coffeeService.show(id);
    }
    // POST
    @PostMapping("/api/coffee")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeForm dto){
        Coffee created = coffeeService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // PATCH
    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> update(@PathVariable long id,@RequestBody CoffeeForm dto){
        Coffee updated = coffeeService.update(id,dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // DELETE
    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable long id){
        Coffee deleted = coffeeService.delete(id);
        return (deleted != null)?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}

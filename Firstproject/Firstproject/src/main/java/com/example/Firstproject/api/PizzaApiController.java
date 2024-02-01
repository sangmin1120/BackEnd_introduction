package com.example.Firstproject.api;

import com.example.Firstproject.dto.PizzaDto;
import com.example.Firstproject.entity.Pizza;
import com.example.Firstproject.repository.PizzaRepository;
import com.example.Firstproject.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    private PizzaService pizzaService;

    // 생성
    @PostMapping("/api/pizza")
    public Pizza create(@RequestBody PizzaDto dto){
        // 서비스에 위임
        Pizza created = pizzaService.create(dto);
        // 반환
        return created;
    }

    // 단건 조회
    @GetMapping("/api/pizza/{id}")
    public Pizza show(@PathVariable Long id){
        return pizzaService.show(id);
    }
    // 목록 조회
    @GetMapping("/api/pizza")
    public ArrayList<Pizza> index(){
        return pizzaService.index();
    }
    // 수정
    @PatchMapping("/api/pizza/{id}")
    public ResponseEntity<Pizza> patch(@PathVariable long id, @RequestBody PizzaDto dto){
        // 서비스 위임
        Pizza updated = pizzaService.patch(id,dto);
        // DTO 변환 및 반환
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // 삭제
    @DeleteMapping("/api/pizza/{id}")
    public ResponseEntity<Pizza> delete(@PathVariable Long id){
        // 서비스 위임
        Pizza deleted = pizzaService.delete(id);
        // 반환
        return (deleted != null)?
                ResponseEntity.status(HttpStatus.OK).body(deleted):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

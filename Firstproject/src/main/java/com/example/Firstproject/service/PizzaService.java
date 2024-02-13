package com.example.Firstproject.service;

import com.example.Firstproject.dto.PizzaDto;
import com.example.Firstproject.entity.Article;
import com.example.Firstproject.entity.Pizza;
import com.example.Firstproject.repository.PizzaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza create(PizzaDto dto){
        Pizza pizza = dto.toEntity();
        if (pizza.getId() != null)
            return null;
        return pizzaRepository.save(pizza);
    }
    public ArrayList<Pizza> index() {
        return pizzaRepository.findAll();
    }

    public Pizza show(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }

    @Transactional
    public Pizza patch(long id, PizzaDto dto) {
        Pizza pizza = dto.toEntity();
        log.info("id: {},articles: {}",id, pizza.toString());
        // DB에 대상 엔티티가 있는 지 조회
        Pizza target = pizzaRepository.findById(id).orElse(null);
        if (target==null || id != pizza.getId()) {
            // 400, 잘못된 요청 응답!
            log.info("잘못된 요청! id: {},article: {}", id, pizza.toString());
            return null;
        }
        target.patch(pizza);
        Pizza updated = pizzaRepository.save(target);
        return updated;
    }

    public Pizza delete(Long id) {
        // target 확인 및 예외 처리
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제 실패! " + "id를 확인해 주세요"));
        // DB에서 삭제
        pizzaRepository.delete(target);
        // 반환
        return target;
    }
}

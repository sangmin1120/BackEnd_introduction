package com.example.Firstproject.dto;

import com.example.Firstproject.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@ToString
@Getter
public class PizzaDto {
    private Long id;
    private  String name;
    private  String price;

    public Pizza toEntity(){
        return new Pizza(id,name,price);
    }
}

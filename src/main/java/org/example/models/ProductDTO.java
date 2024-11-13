package org.example.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Component
public class ProductDTO {

    private int id;

    @Size(min=3, message = "name must be more than 3 charachters")
    private String name;

    @Min(value = 1000, message = "price should be greater then 1000")
    private int price;

    private String type;
    private Map<String, String> validTypes;

    public ProductDTO(){
        validTypes = new HashMap<>();
        validTypes.put("1","home");
        validTypes.put("2","school");
        validTypes.put("3","home");
    }

    public ProductDTO(int id, String name, int price, String type) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}

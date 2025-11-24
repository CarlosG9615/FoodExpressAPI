package es.daw.foodexpressapi.service;

import es.daw.foodexpressapi.dto.DishDTO;
import es.daw.foodexpressapi.entity.Dish;
import es.daw.foodexpressapi.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public List<DishDTO> getAllDishes(){
        return dishRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public DishDTO toDTO(Dish dish){
        return DishDTO.builder()
                .name(dish.getName())
                .price(dish.getPrice())
                .category(dish.getCategory())
                .restaurantName(dish.getRestaurant() != null ?
                        dish.getRestaurant().getName() : "Desconocido")
                .build();
    }
}

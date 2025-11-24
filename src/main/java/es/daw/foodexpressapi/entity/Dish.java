package es.daw.foodexpressapi.entity;

import es.daw.foodexpressapi.dto.DishDTO;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(name = "dishes")
@Getter
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(precision = 8, scale = 2)
    private BigDecimal price;

    @Column(length = 50)
    private String category;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public DishDTO toDTO() {
        return DishDTO.builder()
                .name(this.name)
                .price(this.price)
                .category(this.category)
                .restaurantName(this.restaurant != null ? this.restaurant.getName() : "Unknown")
                .build();
    }

}

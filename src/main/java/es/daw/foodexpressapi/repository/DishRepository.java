package es.daw.foodexpressapi.repository;

import es.daw.foodexpressapi.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}

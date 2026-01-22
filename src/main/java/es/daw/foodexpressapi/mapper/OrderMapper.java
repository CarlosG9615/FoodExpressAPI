
package es.daw.foodexpressapi.mapper;

import es.daw.foodexpressapi.dto.order.OrderResponseDTO;
import es.daw.foodexpressapi.dto.order.OrderSummaryDTO;
import es.daw.foodexpressapi.entity.Order;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    public OrderResponseDTO toResponse(Order o) {
        return OrderResponseDTO.builder()
                .id(o.getId())
                .orderDate(o.getOrderDate())
                //.status(o.getStatus())
                .status(o.getStatus().name())
                .userId(o.getUser().getId())
                .username(o.getUser().getUsername())
                .restaurantId(o.getRestaurant().getId())
                .restaurantName(o.getRestaurant().getName())
                .build();
    }

}

package es.daw.foodexpressapi.dto.order;

import es.daw.foodexpressapi.enums.DishCategory;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record OrderDetailViewDTO(
        @NotEmpty
        String dishName,
        //@Pattern()
        DishCategory category, //pendiente mejora!!! tipo enumerado
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal subtotal
) {
}

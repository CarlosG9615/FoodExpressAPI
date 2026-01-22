
package es.daw.foodexpressapi.controller;

import es.daw.foodexpressapi.dto.*;
import es.daw.foodexpressapi.dto.order.CreateOrderDTO;
import es.daw.foodexpressapi.dto.order.OrderResponseDTO;
import es.daw.foodexpressapi.dto.order.OrderSummaryDTO;
import es.daw.foodexpressapi.dto.report.CustomerTotalDTO;
import es.daw.foodexpressapi.service.OrderService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
//@Validated //?????????????
public class OrderController {

    private final OrderService orderService;

//    @GetMapping
//    public ResponseEntity<List<OrderResponseDTO>> filterOrders(
//            @RequestParam(required = false) String status,
//            @Min(1) @RequestParam(required = false) Long userId,
//            @RequestParam(required = false) Long restaurantId
//    ) {
//
//        return ResponseEntity.ok(orderService.filterOrders(status, userId, restaurantId));
//
//    }
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> filterOrders(
        @RequestParam(required = false) String status,
        @Min(1) @RequestParam(required = false) Long userId,
        @RequestParam(required = false) Long restaurantId
    ) {
        return ResponseEntity.ok(orderService.filterOrders(status, userId, restaurantId));
    }

    @GetMapping("/summary")
    public ResponseEntity<List<OrderSummaryDTO>> getOrderSummaries() {
        return ResponseEntity.ok(orderService.getAllOrderSummaries());
    }

    // PENDIENTE!!!!! CREAR PEDIDO
    @PostMapping
    public ResponseEntity<OrderResponseDTO> crearPedido(@RequestBody CreateOrderDTO dto){
        return null;
    }


    @GetMapping("/best-restaurants")
    public ResponseEntity<List<RestaurantOrderCountDTO>> getBestRestaurant(){
        return ResponseEntity.ok(orderService.getAllRestaurantOrderCounts());
    }

    @GetMapping("/best-dishes")
    public ResponseEntity<List<DishesOrderCountDTO>> getBestDishes(){
        return ResponseEntity.ok(orderService.getAllDishesOrderCounts());
    }
    @GetMapping("/paginated")
    public ResponseEntity<Page<OrderSummaryDTO>> getAllOrdersPaginated(
            Pageable pageable,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long restaurantId
    ) {

        // Si hay filtros, usa el método de filtrado
        if (status != null || userId != null || restaurantId != null) {
            // Implementar lógica de filtrado
            // Por ahora, como no se cargan filtros muestra todos
        }

        return ResponseEntity.ok(orderService.getAllOrders(pageable));
    }
}

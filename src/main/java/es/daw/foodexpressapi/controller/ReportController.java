
package es.daw.foodexpressapi.controller;

/*
¿Cuánto ha gastado cada cliente?

Gasto total por cliente (suma de subtotales).

GET /api/reports/customers/spend

¿Qué restaurantes tienen más ventas?

Restaurantes con más pedidos (COUNT de órdenes)

GET /api/reports/restaurants/top-by-orders
¿Cuáles son los platos más vendidos?

Platos más vendidos por unidades (SUM de quantity)

GET /api/reports/dishes/top-by-units
 */

import es.daw.foodexpressapi.dto.report.CustomerSpendDTO;
import es.daw.foodexpressapi.dto.report.CustomerTotalDTO;
import es.daw.foodexpressapi.dto.report.DishUnitsSoldDTO;
import es.daw.foodexpressapi.dto.report.RestaurantOrdersDTO;
import es.daw.foodexpressapi.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    //    ¿Cuánto ha gastado cada cliente?
//    Gasto total por cliente (suma de subtotales).
//    GET /api/reports/customers/spend
    @GetMapping("/customers/spend")
    public ResponseEntity<List<CustomerSpendDTO>> getCustomerSpend() {
        return ResponseEntity.ok(reportService.getCustomerSpend());
    }

    // GET /api/reports/restaurants/top-by-orders
    @GetMapping("/restaurants/top-by-orders")
    public ResponseEntity<List<RestaurantOrdersDTO>> getTopRestaurantsByOrders() {
        return ResponseEntity.ok(reportService.getTopRestaurantsByOrders());
    }
    // GET /api/reports/dishes/top-by-units
    // MEJORAS!!!
    //- @Validation.... no puede ser superior a 100
    // - no deberia usar limit si no usar paginacion!!!! usaria size
    @GetMapping("/dishes/top-by-units")
    public ResponseEntity<Page<DishUnitsSoldDTO>> getTopDishesByUnitsSold(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(reportService.getTopDishesByUnitsSold(pageable));
    }
    // -- JUAN --- MEJOR LLEVARLOS A UN ReportController....
    @GetMapping("/orders/totals-by-customer")
    public ResponseEntity<List<CustomerTotalDTO>> getCustomerTotalsByCustomer(){
        return ResponseEntity.ok(reportService.getAllCustomerTotals());
    }
}

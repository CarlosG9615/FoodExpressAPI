
package es.daw.foodexpressapi.service;

import es.daw.foodexpressapi.dto.report.CustomerSpendDTO;
import es.daw.foodexpressapi.dto.report.CustomerTotalDTO;
import es.daw.foodexpressapi.dto.report.DishUnitsSoldDTO;
import es.daw.foodexpressapi.dto.report.RestaurantOrdersDTO;
import es.daw.foodexpressapi.repository.OrderDetailRepository;
import es.daw.foodexpressapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public List<CustomerSpendDTO> getCustomerSpend(){
        return orderRepository.findCustomerSpend();
    }

    public List<RestaurantOrdersDTO> getTopRestaurantsByOrders(){
        return orderRepository.findTopRestaurantsByOrders();
    }

    public Page<DishUnitsSoldDTO> getTopDishesByUnitsSold(Pageable pageable) {
        return orderDetailRepository.findTopDishesByUnitsSold(pageable);
    }

    public List<CustomerTotalDTO> getAllCustomerTotals() {
        return orderRepository.findAllCustomerTotals();
    }


}

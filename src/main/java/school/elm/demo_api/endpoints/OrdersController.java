package school.elm.demo_api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import school.elm.demo_api.orders.ErrorResponse;
import school.elm.demo_api.orders.Orders;
import school.elm.demo_api.orders.OrdersListResponse;
import school.elm.demo_api.orders.OrdersRepository;
import school.elm.demo_api.orders.OrdersResponse;

@RestController
public class OrdersController {

	@Autowired
    private OrdersRepository orderRepository;
	
    @GetMapping("/orders")
    public ResponseEntity<Object> getAllOrders() {
        Iterable<Orders> orders = orderRepository.findAll();
        OrdersListResponse response = new OrdersListResponse("Orders retrieved successfully", orders);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Integer id) {
        Orders order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            OrdersResponse response = new OrdersResponse("Order retrieved successfully", order);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            ErrorResponse response = new ErrorResponse("Order not found", "The requested order does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<Object> createOrder(@RequestBody Orders order) {
        orderRepository.save(order);
        OrdersResponse response = new OrdersResponse("Order created successfully", order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Integer id, @RequestBody Orders order) {
        Orders existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setCustomerName(order.getCustomerName());
            existingOrder.setAddress(order.getAddress());
            existingOrder.setAmount(order.getAmount());
            orderRepository.save(existingOrder);
            OrdersResponse response = new OrdersResponse("Order updated successfully", existingOrder);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            ErrorResponse response = new ErrorResponse("Order not found", "The requested order does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") Integer id) {
        Orders order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
            OrdersResponse response = new OrdersResponse("Order deleted successfully", order);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            ErrorResponse response = new ErrorResponse("Order not found", "The requested order does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

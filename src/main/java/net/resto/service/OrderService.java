package net.resto.service;

import net.resto.entity.Order;
import net.resto.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository order;
    public void saveOrder(Order product){
        order.save(product);
    }
    public List<Order> getAllOrders() {
        return order.findAll();
    }
    public byte[] getImageData(int id) {
        return order.findById(id)
                .map(Order::getData)
                .orElse(null);
    }
    public double calculateTotalPrice() {
        List<Order> orders = order.findAll();
        return orders.stream()
                .mapToDouble(order -> order.getPrice())
                .sum();
    }
    public void deleteById(int id){
        order.deleteById(id);
    }
}

package net.resto.controller;

import net.resto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}/image")
    public byte[] getOrderImage(@PathVariable int id) {

        return orderService.getImageData(id);
    }

    @RequestMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id){
        orderService.deleteById(id);
        return "redirect:/orders";
    }
}

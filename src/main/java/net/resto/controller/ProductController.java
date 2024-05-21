package net.resto.controller;

import net.resto.entity.Order;
import net.resto.entity.Product;
import net.resto.service.OrderService;
import net.resto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/products")
    public RedirectView uploadImage(@RequestParam MultipartFile file,
                                    @RequestParam String name,
                                    @RequestParam String description,
                                    @RequestParam double price,
                                    RedirectAttributes redirectAttributes) throws IOException {
        productService.uploadImage(name, description, price, file.getBytes());
        redirectAttributes.addFlashAttribute("successMessage", "Product uploaded successfully!");
        return new RedirectView("http://localhost:8080/success");
    }

    @GetMapping("products/{id}/image")
    public byte[] getImage(@PathVariable int id) {
        return productService.getImageData(id);
    }

    @RequestMapping("products/order/{id}")
    public String getOrder(@PathVariable int id){
        Product b=productService.getProductById(id);
        Order o=new Order(b.getId(),b.getName(),b.getDescription(),b.getPrice(),b.getData());
        orderService.saveOrder(o);
        return "redirect:/order";
    }
    @RequestMapping("/deleteProduct/{id}")
    public RedirectView deleteOrder(@PathVariable int id, Model model){
        productService.deleteById(id);
        return new RedirectView("http://localhost:8080/getProduct");
    }

    @GetMapping("/menu")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}

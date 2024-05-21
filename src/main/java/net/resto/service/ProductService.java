package net.resto.service;

import net.resto.entity.Product;
import net.resto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void uploadImage(String name, String description, double price, byte[] data) {
        Product product = new Product(name, description, price, data);
        productRepository.save(product);
    }

    public byte[] getImageData(int id) {
        return productRepository.findById(id)
                .map(Product::getData)
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(int id){
        return productRepository.findById(id).get();
    }
    public void deleteById(int id){
        productRepository.deleteById(id);
    }
}
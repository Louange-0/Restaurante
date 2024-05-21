package net.resto.controller;

import net.resto.entity.Employee;
import net.resto.entity.Order;
import net.resto.entity.Product;
import net.resto.service.EmployeeService;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/employees")
    public RedirectView uploadImage(@RequestParam MultipartFile file,
                                    @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam double salary,
                                    RedirectAttributes redirectAttributes) throws IOException {
        employeeService.uploadImage(name, email, salary, file.getBytes());
        redirectAttributes.addFlashAttribute("successMessage", "Employee added successfully!");
        return new RedirectView("http://localhost:8080/success");
    }

    @GetMapping("employees/{id}/image")
    public byte[] getImage(@PathVariable int id) {
        return employeeService.getImageData(id);
    }


    @RequestMapping("/deleteEmployee/{id}")
    public RedirectView deleteEmployee(@PathVariable int id, Model model){
        employeeService.deleteById(id);
        return new RedirectView("http://localhost:8080/getEmployees");
    }

    @GetMapping("/employees")
    public List<Employee> getAllProducts() {
        return employeeService.getAllEmployees();
    }
}

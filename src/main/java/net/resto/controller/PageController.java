package net.resto.controller;

import net.resto.entity.Order;
import net.resto.entity.Product;
import net.resto.entity.Employee;
import net.resto.service.EmployeeService;
import net.resto.service.OrderService;
import net.resto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

	private final ProductService productService;
	private final EmployeeService employeeService;
	@Autowired
	private OrderService orderService;

	// This method just redirects to the form page
	@PostMapping("/submitOrder")
	public String submitOrder() {
		return "redirect:/customerDetails";
	}

	// This method shows the form for customer details
	@GetMapping("/customerDetails")
	public String customerDetailsForm(Model model) {
		model.addAttribute("order", new Order());
		return "customerDetails";
	}
	public PageController(ProductService productService, EmployeeService employeeService) {
		this.productService = productService;
        this.employeeService = employeeService;
    }
	@GetMapping("/")
	public String home() {
		return "welcome";
	}
	@GetMapping("/customer")
	public String customer(){
		return "home";
			}

	@GetMapping("/addProduct")
	public String addProductPage() {
		return "addProduct";
	}

	@GetMapping("/getProducts")
	public String getProductsPage(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "menu";
	}
	@GetMapping("/getProduct")
	public String getProductPage(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "menu2";
	}
	@GetMapping("/getEmployees")
	public String getEmployeePage(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employees";
	}
	@GetMapping("/orders")
	public String getOrdersPage(Model model) {
		List<Order> orders = orderService.getAllOrders();
		model.addAttribute("orders", orders);
		// Calculate total price
		double totalPrice = orderService.calculateTotalPrice();
		model.addAttribute("totalPrice", totalPrice);
		return "order";
	}


	@PostMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable int id) {
		orderService.deleteById(id);
		return "redirect:/orders";
	}
	@RequestMapping("/order/{id}")
	public String getOrder(@PathVariable int id){
		Product b=productService.getProductById(id);
		Order o=new Order(b.getId(),b.getName(),b.getDescription(),b.getPrice(),b.getData());
		orderService.saveOrder(o);
		return "redirect:/orders";
	}

	@GetMapping("/feedback")
	public String feedback(){
		return "feedback";
	}
	@GetMapping("/thanks")
	public String thanks(){
		return "thanks";
	}
	@GetMapping("/manager")
	public String manager(){
		return "manager";
	}
	@GetMapping("/success")
	public String success(){
		return "success";
	}
	@GetMapping("/addEmployee")
	public String addEmployee(){
		return "addEmployee";
	}
}

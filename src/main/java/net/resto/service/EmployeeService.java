package net.resto.service;

import net.resto.entity.Employee;
import net.resto.entity.Product;
import net.resto.repository.EmployeeRepository;
import net.resto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void uploadImage(String name, String email, double salary, byte[] data) {
        Employee newone= new Employee(name, email, salary, data);
        employeeRepository.save(newone);
    }

    public byte[] getImageData(int id) {
        return employeeRepository.findById(id)
                .map(Employee::getData)
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).get();
    }
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }
}
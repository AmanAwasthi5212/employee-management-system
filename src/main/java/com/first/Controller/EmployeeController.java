package com.first.Controller;

import com.first.Model.Employee;
import com.first.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/home")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getUser")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @PostMapping("/addUser")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/deleteUser")
    public String deleteEmployee(@RequestBody Employee employee){
        return employeeService.deleteEmployee(employee);
    }

    @PutMapping("/updateUser/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable long id){
        return employeeService.updateEmployee(employee, id);
    }
}


package com.first.Controller;

import com.first.DTO.updateEmployeeDTO;
import com.first.Model.Employee;
import com.first.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/deleteUser")
    public String deleteEmployee(@RequestBody Employee employee){
        return employeeService.deleteEmployee(employee);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateEmployee( @RequestBody updateEmployeeDTO employee, @PathVariable long id){
        String result = employeeService.updateEmployee(employee, id);
        return ResponseEntity.ok(result);
    }
}


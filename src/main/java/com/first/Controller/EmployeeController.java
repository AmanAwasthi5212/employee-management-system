package com.first.Controller;


import com.first.DTO.updateEmployeeDTO;
import com.first.Model.Employee;
import com.first.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/home")
@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getUser")
    public ResponseEntity<List<Employee>> getEmployee() {
        return ResponseEntity.ok(employeeService.getEmployee());
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee){
        String result =  employeeService.deleteEmployee(employee);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateEmployee( @RequestBody updateEmployeeDTO employee, @PathVariable long id){
        String result = employeeService.updateEmployee(employee, id);
        return ResponseEntity.ok(result);
    }
}


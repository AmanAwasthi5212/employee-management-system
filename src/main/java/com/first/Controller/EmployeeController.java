package com.first.Controller;


import com.first.DTO.updateEmployeeDTO;
import com.first.Model.Employee;
import com.first.Service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/home")
@RequiredArgsConstructor
@RestController
@Tag(name= "Employee Management APIs", description = "Read, Add, Delete, and Update Employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees in the system")
    @GetMapping("/getUser")
    public ResponseEntity<List<Employee>> getEmployee() {
        return ResponseEntity.ok(employeeService.getEmployee());
    }

    @Operation(summary = "Add a new employee", description = "Add a new employee to the system")
    @ApiResponse(responseCode = "200", description = "Employee added successfully")
    @PostMapping("/addUser")
    public ResponseEntity<String> addEmployee( @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Employee details to add",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = Employee.class)
            ))@Valid @org.springframework.web.bind.annotation.RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @Operation(summary = "Delete an employee", description = "Delete an existing employee from the system")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee){
        String result =  employeeService.deleteEmployee(employee);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Update an employee", description = "Update details of an existing employee in the system")
    @Parameter(name = "id", description = "ID of the employee needed to update employee", example = "1")
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateEmployee( @RequestBody updateEmployeeDTO employee, @PathVariable long id){
        String result = employeeService.updateEmployee(employee, id);
        return ResponseEntity.ok(result);
    }
}


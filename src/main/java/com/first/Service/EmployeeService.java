package com.first.Service;

import com.first.DTO.updateEmployeeDTO;
import com.first.Model.Employee;
import com.first.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository empRepository;

    public List<Employee> getEmployee() {
        return empRepository.findAll();
    }

    public String addEmployee(Employee emp) {
        boolean exists = empRepository.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase
                (emp.getFirstName(), emp.getLastName());
        if (!exists) {
            empRepository.save(emp);
            return "Employee added successfully";
        } else return "Employee already exist";
    }

    public String deleteEmployee(Employee emp){
        boolean exists = empRepository.existsById(emp.getId());
        if (exists) {
            empRepository.delete(emp);
            return "Employee deleted successfully";
        } else return "Employee does not exist";
    }

    public String updateEmployee(updateEmployeeDTO emp, long id){
        return empRepository.findById(id).map(existingEmp -> {
            if(emp.getFirstName() != null) existingEmp.setFirstName(emp.getFirstName());
            if(emp.getLastName() != null) existingEmp.setLastName(emp.getLastName());
            if(emp.getDepartment() != null) existingEmp.setDepartment(emp.getDepartment());
            if(emp.getSalary() != 0) existingEmp.setSalary(emp.getSalary());
            empRepository.save(existingEmp);
            return "Employee updated successfully";
        }).orElse("Employee does not exist");

    }
}

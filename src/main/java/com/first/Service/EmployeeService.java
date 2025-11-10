package com.first.Service;

//import com.first.Model.DummyEmployeeData;
import com.first.Model.Employee;
import com.first.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepository;

    public List<Employee> getEmployee() {
        return empRepository.findAll();
    }

    public String addEmployee(Employee emp) {
        boolean exists = empRepository.findAll().stream()
                .anyMatch(e -> e.getId() == emp.getId() &&
                        e.getFirstName().equals(emp.getFirstName()) &&
                        e.getLastName().equals(emp.getLastName()));
        if (!exists) {
            empRepository.save(emp);
            return "User added successfully";
        } else return "user already exist";
    }

    public String deleteEmployee(Employee emp){
        boolean exists = empRepository.existsById(emp.getId());
        if (exists) {
            empRepository.delete(emp);
            return "User deleted successfully";
        } else return "User does not exist";
    }

    public String updateEmployee(Employee emp, long id){
        return empRepository.findById(id).map(existingEmp -> {
            if(emp.getFirstName() != null) existingEmp.setFirstName(emp.getFirstName());
            if(emp.getLastName() != null) existingEmp.setLastName(emp.getLastName());
            if(emp.getDepartment() != null) existingEmp.setDepartment(emp.getDepartment());
            if(emp.getSalary() != 0) existingEmp.setSalary(emp.getSalary());
            empRepository.save(existingEmp);
            return "User updated successfully";
        }).orElse("User does not exist");

//          Optional<Employee> existingEmp = empRepository.findById(id);
//            if(existingEmp.isPresent()){
//                Employee updatedEmp = existingEmp.get();
//                if(emp.getName() != null) updatedEmp.setName(emp.getName());
//                if(emp.getDepartment() != null) updatedEmp.setDepartment(emp.getDepartment());
//                if(emp.getSalary() != 0) updatedEmp.setSalary(emp.getSalary());
//                empRepository.save(updatedEmp);
//                return "User updated successfully";
//            } else return "User does not exist";
    }
}

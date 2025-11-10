package com.first.DTO;

public class EmployeeDTO {
    private long id;
    private String name;
    private String department;
    private double salary;

    public EmployeeDTO(){};

    public EmployeeDTO(long id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

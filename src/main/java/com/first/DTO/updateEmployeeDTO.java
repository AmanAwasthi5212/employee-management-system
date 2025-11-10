package com.first.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class updateEmployeeDTO {

    private String firstName;
    private String lastName;
    private String department;
    private double salary;

}

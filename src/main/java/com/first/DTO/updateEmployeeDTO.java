package com.first.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class updateEmployeeDTO {

    @Schema(description = "First name of the employee", example = "John")
    private String firstName;
    @Schema(example="Doe")
    private String lastName;
    @Schema(example = "Engineering")
    private String department;
    @Schema(example = "75000")
    private double salary;

}

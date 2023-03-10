package com.example.project_1.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
 @Data

public class UpdateByNameSalaryIdDTO {

    private String customerName;
    private double customerSalary;
    private String nic;

}

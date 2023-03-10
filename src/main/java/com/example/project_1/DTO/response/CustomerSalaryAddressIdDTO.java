package com.example.project_1.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerSalaryAddressIdDTO {

    private int customerId;
    private String customerAddress;
    private double customerSalary;

}

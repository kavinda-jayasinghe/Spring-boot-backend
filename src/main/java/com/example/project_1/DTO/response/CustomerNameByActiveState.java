package com.example.project_1.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerNameByActiveState {
    private String customerName;
    private ArrayList customerNumber;

}

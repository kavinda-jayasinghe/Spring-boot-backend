package com.example.project_1.util.mappers;

import com.example.project_1.DTO.CustomerDTO;
import com.example.project_1.DTO.response.CustomerNameByActiveState;
import com.example.project_1.DTO.response.CustomerSalaryAddressIdDTO;
import com.example.project_1.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO entityToDto(Customer customer);

    List<CustomerDTO> entityListToDtoList(List<Customer> customer);
    List<CustomerNameByActiveState> NameEntityListToDtoList(List<Customer> customer);

    CustomerSalaryAddressIdDTO SalaryAddressIdEntityToDTO(Customer customer);

}
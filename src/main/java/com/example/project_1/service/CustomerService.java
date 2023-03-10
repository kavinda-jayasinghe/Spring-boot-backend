package com.example.project_1.service;

import com.example.project_1.DTO.CustomerDTO;
import com.example.project_1.DTO.request.CustomerSaveRequestDTO;
import com.example.project_1.DTO.request.CustomerUpdateRequestDTO;
import com.example.project_1.DTO.request.UpdateByNameSalaryIdDTO;
import com.example.project_1.DTO.request.UpdateCustomerByQueryDTO;
import com.example.project_1.DTO.response.CustomerNameByActiveState;
import com.example.project_1.DTO.response.CustomerSalaryAddressIdDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveRequestDTO customerDTO);

    String customerUpdate(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO customerGetbyId(int id);

    List<CustomerDTO> getAllCustomers();

    boolean customerDelete(int id) throws NotFoundException;

    List<CustomerDTO> getByName(String customerName) throws NotFoundException;

    List<CustomerDTO> getAllCustomersByActiveState() throws NotFoundException;

    List<CustomerNameByActiveState> getCustomerNameByActiveState() throws NotFoundException;

    String updateByQuery(UpdateCustomerByQueryDTO updateCustomerByQueryDTO, int id);

    CustomerDTO getCustomerByNic(String nic);


    CustomerSalaryAddressIdDTO customerGetByIdFilter(int id);

    String updateByFilter(UpdateByNameSalaryIdDTO updateByNameSalaryIdDTO, int id);
}
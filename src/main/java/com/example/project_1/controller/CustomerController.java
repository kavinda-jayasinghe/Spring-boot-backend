package com.example.project_1.controller;


import com.example.project_1.DTO.CustomerDTO;
import com.example.project_1.DTO.request.CustomerSaveRequestDTO;
import com.example.project_1.DTO.request.CustomerUpdateRequestDTO;
import com.example.project_1.DTO.request.UpdateByNameSalaryIdDTO;
import com.example.project_1.DTO.request.UpdateCustomerByQueryDTO;
import com.example.project_1.DTO.response.CustomerNameByActiveState;
import com.example.project_1.DTO.response.CustomerSalaryAddressIdDTO;
import com.example.project_1.exception.NotFoundException;
import com.example.project_1.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(path="/save")
    public String save(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){
        String name = customerService.addCustomer(customerSaveRequestDTO);
        return name;
}

    @PutMapping(path="/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
        String update=customerService.customerUpdate(customerUpdateRequestDTO);
        return update;

    }

    @GetMapping(path={"/get-by-id"},params="id")

    public CustomerDTO getCustomerByid(@RequestParam(value="id") int id){
       CustomerDTO customerDTO=customerService.customerGetbyId(id);
        return customerDTO;
    }

    @GetMapping(path={"/get-all-customers"})
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers=customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path={"/delete-customer/{id}"}
    )
    public String deleteCustomer( @PathVariable(value = "id") int id) throws NotFoundException {

        boolean customer=customerService.customerDelete(id);
        return " deleted";
    }
    @GetMapping(path={"/get-by-name"},
       params={"name"}
    )
    public List<CustomerDTO> getCustomerByName(@RequestParam(value = "name")String customerName) throws NotFoundException {
        List<CustomerDTO>getCustomer=customerService.getByName(customerName);
        return getCustomer;
    }

    @GetMapping(path={"get-by-active-state"})
    public List<CustomerDTO> getCustomerByActiveState() throws NotFoundException {

        List<CustomerDTO> getCustomers=customerService.getAllCustomersByActiveState();
        return getCustomers;
    }


    @GetMapping(path={"get-by-Name-active-state"})
    public List<CustomerNameByActiveState>  CustomerNameByActiveState() throws NotFoundException {

        List< CustomerNameByActiveState> getCustomers=customerService.getCustomerNameByActiveState();
        return getCustomers;
    }

    @PutMapping(path={"/update-By-query/{id}"})

    public String updateCustomerByQuery(
            @RequestBody UpdateCustomerByQueryDTO updateCustomerByQueryDTO,
            @PathVariable(value = "id") int id){
        String updated=customerService.updateByQuery(updateCustomerByQueryDTO,id);
        return updated;
    }
    @GetMapping("/get-by-name/{nic}")
    public CustomerDTO getByNic(@PathVariable(value = "nic") String nic){
        CustomerDTO getCustomer=customerService.getCustomerByNic(nic);
        return getCustomer;
    }

    @GetMapping(value = "/get-by-id-filter/{id}")
    public CustomerSalaryAddressIdDTO getByIdFilter(@PathVariable(value = "id") int id){
        CustomerSalaryAddressIdDTO customerSalaryAddressIdDTO=customerService.customerGetByIdFilter(id);
        return customerSalaryAddressIdDTO;
    }

    @PutMapping(path={"/update-By-filter/{id}"})

    public String updateCustomerByFilter(
            @RequestBody UpdateByNameSalaryIdDTO updateByNameSalaryIdDTO,
            @PathVariable(value = "id") int id){
        String updated=customerService.updateByFilter(updateByNameSalaryIdDTO,id);
        return updated;
    }

}

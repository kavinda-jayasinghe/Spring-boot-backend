package com.example.project_1.service.impl;

import com.example.project_1.DTO.CustomerDTO;
import com.example.project_1.DTO.request.CustomerSaveRequestDTO;
import com.example.project_1.DTO.request.CustomerUpdateRequestDTO;
import com.example.project_1.DTO.request.UpdateByNameSalaryIdDTO;
import com.example.project_1.DTO.request.UpdateCustomerByQueryDTO;
import com.example.project_1.DTO.response.CustomerNameByActiveState;
import com.example.project_1.DTO.response.CustomerSalaryAddressIdDTO;
import com.example.project_1.entity.Customer;
import com.example.project_1.exception.EntryDuplicationException;
import com.example.project_1.repository.CustomerRepo;
import com.example.project_1.service.CustomerService;
import com.example.project_1.util.mappers.CustomerMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {
         Customer customer = new Customer(

                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getCustomerSalary(),
                customerSaveRequestDTO.getCustomerNumber(),
                customerSaveRequestDTO.getNic()
        );
        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return customer.getCustomerName() + " saved";
        } else {
            System.out.println("Customer id already exists");
            return "Customer id already exists";
        }
    }
    @Override
    public String customerUpdate(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if (!customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {
            System.out.println("This Customer not in DB");
            return "This Customer not in DB";

        } else {
            Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerId());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateRequestDTO.getCustomerSalary());
            customer.setCustomerNumber(customerUpdateRequestDTO.getCustomerNumber());
            customer.setNic(customerUpdateRequestDTO.getNic());

            customerRepo.save(customer);
            return customer.getCustomerName() + " updated";
        }
    }

    @Override
    public CustomerDTO customerGetbyId(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
/*
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO
                    (
                            customer.get().getCustomerId(),
                            customer.get().getCustomerName(),
                            customer.get().getCustomerAddress(),
                            customer.get().getCustomerSalary(),
                            customer.get().getCustomerNumber(),
                            customer.get().isActiveState(),
                            customer.get().getNic()
                    );
            return customerDTO; */

        //=====================using model mapper

 /*    CustomerDTO customerDTO=modelMapper
            return customerDTO;
*/
return null;
        }

        //=====================mapstruct

/*       if (customer.isPresent()){
            CustomerDTO customerDTO=customerMapper.entityToDto(customer.get());
            return customerDTO;
        }else{
            return null;
        }

    }*/


    //=======================using for each
    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer c : getCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    c.getCustomerId(),
                    c.getCustomerName(),
                    c.getCustomerAddress(),
                    c.getCustomerSalary(),
                    c.getCustomerNumber(),
                    c.isActiveState(),
                    c.getNic()
            );
            customerDTOList.add(customerDTO);
        }
        //============using model mapper
        // List<CustomerDTO> customerDTOS=modelMapper.map(getCustomers,new TypeToken<List<CustomerDTO>>(){}.getType());


        return customerDTOList;
    }
//=======================================Delete customer
    @Override
    public boolean customerDelete(int id) throws NotFoundException {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);

        }else{
           throw new NotFoundException("not found customer for this id");
        }

        return true;
    }


    @Override
    public List<CustomerDTO> getByName(String customerName) throws NotFoundException {
        List<Customer> customers=customerRepo.findAllByCustomerNameEquals(customerName);

        if(customers.size()!=0){

            List<CustomerDTO> customerDTO=customerMapper.entityListToDtoList(customers);
            return customerDTO;
        }else{
            throw new NotFoundException("No results");
        }

    }
   @Override
    public List<CustomerDTO> getAllCustomersByActiveState() throws NotFoundException {
       List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
       if (customers.size() != 0) {

           List<CustomerDTO> customerDTOS = customerMapper.entityListToDtoList(customers);
           return customerDTOS;
       } else {
           throw new NotFoundException("No active customer found..");
       }
   }

    @Override
    public List<CustomerNameByActiveState> getCustomerNameByActiveState() throws NotFoundException {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(false);
        if (customers.size() != 0) {

            List<CustomerNameByActiveState> customerDTOS = customerMapper.NameEntityListToDtoList(customers);
            return customerDTOS;
        } else {
            throw new NotFoundException("No active customer found..");
        }
    }

    @Override
    public String updateByQuery(UpdateCustomerByQueryDTO updateCustomerByQueryDTO, int id) {
        if(customerRepo.existsById(id)){
            customerRepo.updateCustomerByQuery(updateCustomerByQueryDTO.getCustomerName(),updateCustomerByQueryDTO.getNic(),id);
            return "customer updated "+id;
        }else {
            return "cannot update...";
        }

    }


    @Override
    public CustomerDTO getCustomerByNic(String nic) {
        Customer customer=customerRepo.findByNicEquals(nic);
        if (customer!=null){
            CustomerDTO customerDTO=customerMapper.entityToDto(customer);
            return customerDTO;

        }else {
throw new com.example.project_1.exception.NotFoundException("Not found ");
        }


    }

    @Override
    public CustomerSalaryAddressIdDTO customerGetByIdFilter(int id) {
        Optional<Customer> customer=customerRepo.findById(id);
        if(customer.isPresent()){
            CustomerSalaryAddressIdDTO customerSalaryAddressIdDTO=customerMapper.SalaryAddressIdEntityToDTO(customer.get());
            return customerSalaryAddressIdDTO;
        }
        return null;
    }

    @Override
    public String updateByFilter(UpdateByNameSalaryIdDTO updateByNameSalaryIdDTO, int id) {
        if(customerRepo.existsById(id)){
           Customer customer=customerRepo.getById(id);


            customer.setCustomerName(updateByNameSalaryIdDTO.getCustomerName());
            customer.setCustomerSalary(updateByNameSalaryIdDTO.getCustomerSalary());
            customer.setNic(updateByNameSalaryIdDTO.getNic());
            return customerRepo.save(customer).getCustomerName()+" updated success "+id;
        }else {
     throw new EntryDuplicationException("not in DB");
        }
    }


}





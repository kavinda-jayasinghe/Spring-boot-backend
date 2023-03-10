package com.example.project_1.DTO.request;

import java.util.ArrayList;

public class CustomerSaveRequestDTO {


    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private ArrayList customerNumber;
    private String nic;

    public CustomerSaveRequestDTO() {
    }

    public CustomerSaveRequestDTO(String customerName, String customerAddress, double customerSalary, ArrayList customerNumber, String nic) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.customerNumber = customerNumber;
        this.nic = nic;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public ArrayList getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(ArrayList customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String  toString() {
        return "CustomerSaveRequestDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", customerNumber=" + customerNumber +
                ", nic='" + nic + '\'' +
                '}';
    }
}

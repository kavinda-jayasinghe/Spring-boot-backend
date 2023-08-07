package com.example.project_1.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {
    @Id
    @Column(name="customer_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name",length = 50,nullable = false)
    private String customerName;

    @Column(name="customer_address")
    private String customerAddress;

    @Column(name="customer_salary")
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "customer_number",columnDefinition = "json")
    private ArrayList customerNumber;

    @Column(name = "nic",length = 10,unique = true)
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="customer")
    private Set<Orders> order;

    public Customer(String customerName, String customerAddress, double customerSalary, ArrayList customerNumber, String nic) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.customerNumber = customerNumber;
        this.nic = nic;
    }


}

package com.example.project_1.entity;

import com.example.project_1.entity.enums.MeasuringUnitType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
@Entity
@Table(name="item")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data

public class  Item {

    @Id
    @Column(name="item_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name="item_name",length = 50,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measuring_unit",length = 50,nullable = false)
    private MeasuringUnitType measuringUnit;

    @Column(name="balace_qty",length = 50,nullable = false)
    private double balanceQty;

    @Column(name="supplier_price",length = 50,nullable = false)
    private double supplierPrice;

    @Column(name="selling_price",length = 50,nullable = false)
    private double sellingPrice;


    @Column(name="active_state",length = 50,nullable = false,columnDefinition = "TINYINT default 1")
    private boolean activeState;







}


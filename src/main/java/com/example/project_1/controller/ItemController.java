package com.example.project_1.controller;

import com.example.project_1.DTO.request.CustomerSaveRequestDTO;
import com.example.project_1.DTO.request.ItemSaveRequestDTO;
import com.example.project_1.service.CustomerService;
import com.example.project_1.service.ItemService;
import com.example.project_1.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    ItemService itemService;

   @PostMapping(path="/save")
    public ResponseEntity<StandardResponse>saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){

        String id = itemService.addItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"item successfully saved",id),
                HttpStatus.CREATED

        );

    }



}

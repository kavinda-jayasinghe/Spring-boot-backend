package com.example.project_1.controller;

import com.example.project_1.DTO.CustomerDTO;
import com.example.project_1.DTO.ItemDTO;
import com.example.project_1.DTO.paginated.PaginatedResponseItemDTO;
import com.example.project_1.DTO.request.CustomerSaveRequestDTO;
import com.example.project_1.DTO.request.ItemSaveRequestDTO;
import com.example.project_1.exception.NotFoundException;
import com.example.project_1.service.CustomerService;
import com.example.project_1.service.ItemService;
import com.example.project_1.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> addItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {

        String id = itemService.addItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id + "item successfully saved", id),
                HttpStatus.CREATED
        );
    }

//    @GetMapping(path={"/get-all-items"})
//    public List<ItemDTO> getAllItems(){
//        List<ItemDTO> allItems=itemService.getAllItems();
//        return allItems;
//    }

    @GetMapping(path = {"/get-all-items"})
    public ResponseEntity<StandardResponse> getAllItems() {

        List<ItemDTO> allItems = itemService.getAllItems();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", allItems),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/get-all-item-by-state"},
            params = {"state"}
    )
    public ResponseEntity<StandardResponse> getAllItemsByState(@RequestParam(value = "state") String state) {

        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {
//            boolean status = false;
//            if(state.equalsIgnoreCase("active")){
//                status = true;
//            }
            boolean status = state.equalsIgnoreCase("active") ? true : false;
            List<ItemDTO> allItems = itemService.getAllItemsByStateType(status);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "success", allItems),
                    HttpStatus.OK
            );

        } else {
            List<ItemDTO> allItems = itemService.getAllItems();
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "success", allItems),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping(
            path = {"/delete-item/{id}"}
    )
    public ResponseEntity<StandardResponse> deleteItem(@PathVariable(value = "id") int id) throws NotFoundException {

        boolean item = itemService.itemDelete(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", item),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/get-active-item-count"},
            params = {"state"}
    )
    public ResponseEntity<StandardResponse> getItemCount() {
        int itemCount = itemService.itemCount();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", itemCount),
                HttpStatus.OK
        );
    }

//    paginated

//    @GetMapping(
//            path = "get-all-atems-pagibated",
//            params = {"page,size"}
//    )
//    public ResponseEntity<StandardResponse> getAllItemsPaginated(
//            @RequestParam(value = "page") int page,
//            @RequestParam(value = "size") int size
//
//    ) {
//        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemsPaginated(page, size);
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200, "success", paginatedResponseItemDTO),
//                HttpStatus.OK
//        );
//    }

//------------------------------------------------------------

//    @GetMapping(
//            path = "get-all-active-items-paginated",
//            params = {"page","size","activeState"}
//    )
//    public ResponseEntity<StandardResponse> getAllActivePaginated(
//            @RequestParam(value="page") int page,
//            @RequestParam(value="size") int size,
//            @RequestParam(value="activeState") boolean activeState
//    ){
//PaginatedResponseItemDTO paginatedResponseItemDTO=itemService.getAllActiveItemsPaginated(page,size,activeState);
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200, "success", paginatedResponseItemDTO),
//                HttpStatus.OK
//        );
//    }

}

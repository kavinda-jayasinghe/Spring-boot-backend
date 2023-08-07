package com.example.project_1.service;

import com.example.project_1.DTO.ItemDTO;
import com.example.project_1.DTO.paginated.PaginatedResponseItemDTO;
import com.example.project_1.DTO.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {
      String addItem(ItemSaveRequestDTO itemSaveRequestDTO);

      List<ItemDTO> getAllItems();

      List<ItemDTO> getAllItemsByStateType(boolean status);


      boolean itemDelete(int id);

      int itemCount();

//      PaginatedResponseItemDTO getAllActiveItemsPaginated(int page, int size, boolean activeState);

//      PaginatedResponseItemDTO getAllItemsPaginated(int page, int size);
}

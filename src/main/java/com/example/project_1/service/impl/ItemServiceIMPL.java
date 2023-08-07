package com.example.project_1.service.impl;

import com.example.project_1.DTO.CustomerDTO;
import com.example.project_1.DTO.ItemDTO;
import com.example.project_1.DTO.paginated.PaginatedResponseItemDTO;
import com.example.project_1.DTO.request.ItemSaveRequestDTO;
import com.example.project_1.entity.Customer;
import com.example.project_1.entity.Item;
import com.example.project_1.exception.EntryDuplicationException;
import com.example.project_1.exception.NotFoundException;
import com.example.project_1.repository.ItemRepo;
import com.example.project_1.service.ItemService;
import com.example.project_1.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item =itemMapper.RequestDtoToEntity(itemSaveRequestDTO);
        item.setActiveState(true);

        if(!itemRepo.existsById(item.getItemId())){
           return itemRepo.save(item).getItemName();
        }
        else {
            throw new EntryDuplicationException("allrady in database");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> getItems = itemRepo.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();
         List<ItemDTO> itemsDTOS=modelMapper.map(getItems,new TypeToken<List<ItemDTO>>(){}.getType());
        return itemsDTOS;
    }

    @Override
    public List<ItemDTO> getAllItemsByStateType(boolean status) {
        List<Item> getItems = itemRepo.findAllByActiveStateEquals(status);
        List<ItemDTO> itemsDTOS=modelMapper.map(getItems,new TypeToken<List<ItemDTO>>(){}.getType());
        return itemsDTOS;
    }

    @Override
    public boolean itemDelete(int id) throws NotFoundException {
        if(itemRepo.existsById(id)){
            itemRepo.deleteById(id);
            return true;
        }else{
            throw new NotFoundException("not found item for this id");
        }
    }

    @Override
    public int itemCount() {
      int itemCount=itemRepo.countAllByActiveState(true);
        return itemCount;
    }


//    @Override
//    public PaginatedResponseItemDTO getAllItemsPaginated(int page, int size) {
//        Page<Item> getAllItemsByPaginated=itemRepo.findAll(PageRequest.of(page,size));
//        return new PaginatedResponseItemDTO(
//                itemMapper.pageToList(getAllItemsByPaginated),
//                10
//        );
//    }


//    @Override
//    public PaginatedResponseItemDTO getAllActiveItemsPaginated(int page, int size, boolean activeState) {
//        Page<Item> getAllActiveItemsByPaginated=itemRepo.findAllByActiveStateEquals(activeState,PageRequest.of(page,size));
//        return new PaginatedResponseItemDTO(
//                itemMapper.pageToList(getAllActiveItemsByPaginated),
//                10
//        );
//    }
}

package com.example.project_1.util.mappers;

import com.example.project_1.DTO.ItemDTO;

import com.example.project_1.DTO.request.ItemSaveRequestDTO;
import com.example.project_1.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item RequestDtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);
//   List<ItemDTO> pageToList(Page<Item>page);
}

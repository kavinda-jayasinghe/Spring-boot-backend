package com.example.project_1.DTO.paginated;

import com.example.project_1.DTO.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    private List<ItemDTO> list;
    private long dataCount;
}

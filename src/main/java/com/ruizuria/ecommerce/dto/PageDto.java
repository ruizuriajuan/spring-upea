package com.ruizuria.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PageDto {
    private List content;
    private boolean last;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;
}

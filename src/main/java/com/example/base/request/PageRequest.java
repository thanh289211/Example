package com.example.base.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest extends BaseRequest{
    private int pageSize = 20;
    private int pageNumber = 1;
}

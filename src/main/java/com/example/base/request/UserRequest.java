package com.example.base.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest extends BaseRequest{
    private String name;
    private String phoneNumber;
    private String address;
}

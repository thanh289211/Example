package com.example.base.business.response;

import com.example.base.business.entities.UserEntity;
import com.example.base.helpers.utils.MapperFactory;
import lombok.Data;
import org.modelmapper.ModelMapper;
@Data
public class UserResponse {
    private long id;
    private String name;
    private String phoneNumber;
    private String address;

    public static UserResponse of (UserEntity userEntity){
        ModelMapper mapper = MapperFactory.mapper(MapperFactory.ModelMapperOptions.DEEP_COPY);
        return mapper.map(userEntity, UserResponse.class);
    }
}

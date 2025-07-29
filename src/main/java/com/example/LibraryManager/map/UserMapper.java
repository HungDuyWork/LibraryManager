package com.example.LibraryManager.map;

import com.example.LibraryManager.dto.request.UserCreationRequest;
import com.example.LibraryManager.dto.response.UserResponse;
import com.example.LibraryManager.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUser(UserCreationRequest request);
    UserResponse createUserResponse(User user);
    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(UserCreationRequest request, @MappingTarget User user);
    List<UserResponse> createUserResponses(List<User> users);
}

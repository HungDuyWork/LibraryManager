package com.example.LibraryManager.map;

import com.example.LibraryManager.dto.request.DeptCreationRequest;
import com.example.LibraryManager.dto.response.DeptResponse;
import com.example.LibraryManager.entity.Dept;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DeptMapper {
    Dept createDept(DeptCreationRequest request);
    DeptResponse deptToResponse(Dept dept);
    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateDept(DeptCreationRequest request, @MappingTarget Dept dept);
}

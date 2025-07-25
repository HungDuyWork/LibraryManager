package com.example.LibraryManager.map;

import com.example.LibraryManager.dto.response.BookCategoryResponse;
import com.example.LibraryManager.entity.BookCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookCategoryMapper {
    BookCategoryResponse toBookCategoryResponse(BookCategory bookCategory);
}

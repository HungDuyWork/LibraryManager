package com.example.LibraryManager.map;

import com.example.LibraryManager.dto.request.BookCategoryRequest;
import com.example.LibraryManager.dto.request.BookCreationRequest;
import com.example.LibraryManager.dto.response.BookCategoryResponse;
import com.example.LibraryManager.dto.response.BookResponse;
import com.example.LibraryManager.dto.response.BookSummaryResponse;
import com.example.LibraryManager.entity.Book;
import com.example.LibraryManager.entity.BookCategory;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "bookCategory", ignore = true)
    Book toBook(BookCreationRequest request);
    BookResponse toBookResponse(Book book);
    BookCategory toBookCategory(BookCategoryRequest request);
    List<BookSummaryResponse> toBookSummaryResponses(List<Book> books);
    List<BookCategoryResponse> toBookCategoryResponses(List<BookCategory> bookCategories);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromRequest(BookCreationRequest request, @MappingTarget Book book);
}

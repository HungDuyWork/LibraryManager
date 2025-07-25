package com.example.LibraryManager.service;

import com.example.LibraryManager.dto.request.BookCategoryRequest;
import com.example.LibraryManager.dto.request.BookCreationRequest;
import com.example.LibraryManager.dto.response.BookCategoryResponse;
import com.example.LibraryManager.dto.response.BookResponse;
import com.example.LibraryManager.dto.response.BookSummaryResponse;
import com.example.LibraryManager.entity.BookCategory;

import java.util.List;

public interface BookService {
    // 1. Thêm sách mới
     BookResponse createBook(BookCreationRequest request);

   // 2. Thêm thể loại sách
     BookCategory createBookCategories(BookCategoryRequest request);
    // 3. Hiển thị sách theo thể loại
     List<BookSummaryResponse> getBooksByCategory(Integer categoryId); // Uncomment if needed
    // 4. Hiển thị tất cả thể loại sách
     List<BookCategoryResponse> getAllBookCategories(); // Uncomment if needed
    // 5. Xóa sách theo ID
    void deleteBook(Long bookId); // Uncomment if needed
    // 6. Xoá thể loại sách theo ID
    void deleteBookCategory(Long categoryId); // Uncomment if needed
    // 7. Update sách theo ID
    BookResponse updateBook(Long bookId, BookCreationRequest request); // Uncomment if needed
    // 8. Update thể loại sách theo ID
    BookCategoryResponse updateBookCategory(Long categoryId, BookCategoryRequest request); // Uncomment if needed
}

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
     List<BookSummaryResponse> getBooksByCategoryName(String categoryName); // Uncomment if needed
    // 4. Hiển thị tất cả thể loại sách
     List<BookCategoryResponse> getAllBookCategories(); // Uncomment if needed
    // 5. Xóa sách theo ID
    void deleteBook(String bookId); // Uncomment if needed
    // 6. Xoá thể loại sách theo ID
    void deleteBookCategory(String categoryId); // Uncomment if needed
    // 7. Update sách theo ID
    BookResponse updateBook(String bookCode, BookCreationRequest request); // Uncomment if needed
    // 8. Update thể loại sách theo tên
    BookCategoryResponse updateBookCategory(String categoryName, BookCategoryRequest request); // Uncomment if needed
    // 9. Tìm kiếm sách dựa trên mã sách
    BookResponse getBookByCode(String bookCode); // Uncomment if needed
    // 10. Tìm kiếm sách dựa trên tên sách
    BookSummaryResponse getBooksByName(String bookName); // Uncomment if needed
    // 11. Tìm kiếm sách dựa trên tên tác giả
    List<BookSummaryResponse> getBooksByAuthor(String bookAuthor); // Uncomment if needed
}

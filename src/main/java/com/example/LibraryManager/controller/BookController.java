package com.example.LibraryManager.controller;

import com.example.LibraryManager.dto.request.BookCategoryRequest;
import com.example.LibraryManager.dto.request.BookCreationRequest;
import com.example.LibraryManager.dto.response.ApiResponse;
import com.example.LibraryManager.dto.response.BookCategoryResponse;
import com.example.LibraryManager.dto.response.BookResponse;
import com.example.LibraryManager.dto.response.BookSummaryResponse;
import com.example.LibraryManager.entity.BookCategory;
import com.example.LibraryManager.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Thêm sách mới
    @PostMapping
    ApiResponse<BookResponse> createBookCategory(@RequestBody @Valid BookCreationRequest request) {
        return ApiResponse.<BookResponse>builder()
                .result(bookService.createBook(request))
                .build();
    }

    // Thêm thể loại sách
    @PostMapping("/categories")
    ApiResponse<BookCategory> createBookCategoriesResponse(@RequestBody BookCategoryRequest request) {
        return ApiResponse.<BookCategory>builder()
                .result(bookService.createBookCategories(request))
                .build();
    }
    // Tìm kiếm sách dựa trên mã sách
    @GetMapping("/code/{bookCode}")
    ApiResponse<BookResponse> getBookByCode(@PathVariable("bookCode") String bookCode) {
        BookResponse bookResponse = bookService.getBookByCode(bookCode);
        return ApiResponse.<BookResponse>builder()
                .result(bookResponse)
                .build();
    }
    // Hiển thị sách theo thể loại dựa trên tên thể loại
    @GetMapping("/categories/{categoryName}/books")
    public ApiResponse<List<BookSummaryResponse>> getBooksByCategoryName(@PathVariable("categoryName") String categoryName) {
        List<BookSummaryResponse> books = bookService.getBooksByCategoryName(categoryName);
        return ApiResponse.<List<BookSummaryResponse>>builder()
                .result(books)
                .build();
    }
    // Hiển thị tất cả thể loại sách
    @GetMapping("/categories")
    public ApiResponse<List<BookCategoryResponse>> getAllBookCategories() {
        List<BookCategoryResponse> categories = bookService.getAllBookCategories();
        return ApiResponse.<List<BookCategoryResponse>>builder()
                .result(categories)
                .build();
    }

    // Xoá sách theo mã sách
    @DeleteMapping("/{bookCode}")
    public ApiResponse<Void> deleteBook(@PathVariable("bookCode") String bookCode) {
        bookService.deleteBook(bookCode);
        return ApiResponse.<Void>builder()
                .result(null)
                .build();
    }

    // Xoá thể loại sách theo tên thể loại
    @DeleteMapping("/categories/{categoryName}")
    public ApiResponse<Void> deleteBookCategory(@PathVariable("categoryName") String categoryName) {
        bookService.deleteBookCategory(categoryName);
        return ApiResponse.<Void>builder()
                .result(null)
                .build();
    }

    // Cập nhật sách theo mã sách
    @PutMapping("/{bookCode}")
    public ApiResponse<BookResponse> updateBook(@PathVariable("bookCode") String bookCode, @RequestBody BookCreationRequest request) {
        BookResponse updated = bookService.updateBook(bookCode, request);
        return ApiResponse.<BookResponse>builder()
                .result(updated)
                .build();
    }

    // Cập nhật thể loại sách theo tên
    @PutMapping("/categories/{categoryName}")
    public ApiResponse<BookCategoryResponse> updateBookCategory(@PathVariable("categoryName") String categoryName, @RequestBody BookCategoryRequest request) {
        BookCategoryResponse updated = bookService.updateBookCategory(categoryName, request);
        return ApiResponse.<BookCategoryResponse>builder()
                .result(updated)
                .build();
    }
    // Tìm kiếm sách theo tên sách
    @GetMapping("/name/{bookName}")
    public ApiResponse<BookSummaryResponse> getBooksByName(@PathVariable("bookName") String bookName) {
        return ApiResponse.<BookSummaryResponse>builder()
                .result(bookService.getBooksByName(bookName))
                .build();
    }
    // Tìm kiếm sách theo tên tác giả
    @GetMapping("/author/{authorName}")
    public ApiResponse<List<BookSummaryResponse>> getBooksByAuthor(@PathVariable("authorName") String authorName) {
        return ApiResponse.<List<BookSummaryResponse>>builder()
                .result(bookService.getBooksByAuthor(authorName))
                .build();
    }

}

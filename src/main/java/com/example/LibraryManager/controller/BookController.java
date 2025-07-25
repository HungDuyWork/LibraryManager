package com.example.LibraryManager.controller;

import com.example.LibraryManager.dto.request.BookCategoryRequest;
import com.example.LibraryManager.dto.request.BookCreationRequest;
import com.example.LibraryManager.dto.response.BookCategoryResponse;
import com.example.LibraryManager.dto.response.BookResponse;
import com.example.LibraryManager.dto.response.BookSummaryResponse;
import com.example.LibraryManager.entity.BookCategory;
import com.example.LibraryManager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Thêm sách mới
    @PostMapping
    BookResponse createBook(@RequestBody BookCreationRequest request) {
        return bookService.createBook(request);
    }
    // Thêm thể loại sách
    @PostMapping("/categories")
    BookCategory createBookCategories(@RequestBody BookCategoryRequest request) {
        return bookService.createBookCategories(request);
    }
    // Hiển thị sách theo thể loại
    @GetMapping("/categories/{categoryId}/books")
    List<BookSummaryResponse> getBooks(@PathVariable("categoryId") Integer categoryId) {
        return bookService.getBooksByCategory(categoryId);
    }
    // Hiển thị tất cả thể loại sách
    @GetMapping("/categories")
    List<BookCategoryResponse> getAllBookCategories() {
        return bookService.getAllBookCategories();
    }
    // Xoa sách theo ID
    @DeleteMapping("/{bookId}")
    void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }
    // Xoá thể loại sách theo ID
    @DeleteMapping("/categories/{categoryId}")
    void deleteBookCategory(@PathVariable("categoryId") Long categoryId) {
        bookService.deleteBookCategory(categoryId);
    }
    // Update sách theo ID
    @PutMapping("/{bookId}")
    BookResponse updateBook(@PathVariable("bookId") Long bookId, @RequestBody BookCreationRequest request) {
        return bookService.updateBook(bookId, request);
    }
    // Update thể loại sách theo ID
    @PutMapping("/categories/{categoryId}")
    BookCategoryResponse updateBookCategory(@PathVariable("categoryId") Long categoryId, @RequestBody BookCategoryRequest request) {
        return bookService.updateBookCategory(categoryId, request);
    }
}

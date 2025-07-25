package com.example.LibraryManager.service.Impl;

import com.example.LibraryManager.dto.request.BookCategoryRequest;
import com.example.LibraryManager.dto.request.BookCreationRequest;
import com.example.LibraryManager.dto.response.BookCategoryResponse;
import com.example.LibraryManager.dto.response.BookResponse;
import com.example.LibraryManager.dto.response.BookSummaryResponse;
import com.example.LibraryManager.entity.Book;
import com.example.LibraryManager.entity.BookCategory;
import com.example.LibraryManager.map.BookCategoryMapper;
import com.example.LibraryManager.map.BookMapper;
import com.example.LibraryManager.repository.BookCategoryRepository;
import com.example.LibraryManager.repository.BookRepository;
import com.example.LibraryManager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookCategoryRepository bookCategoryRepository ;
    @Autowired
    private BookCategoryMapper bookCategoryMapper;
    // 1. Thêm sách mới
    @Override
    public BookResponse createBook(BookCreationRequest request) {
        Book book = bookMapper.toBook(request);
        BookCategory bookCategory = bookCategoryRepository.findById(request.getBookCategoryId())
                .orElseThrow(() -> new RuntimeException("Book category not found with id: "));
        book.setBookCategory(bookCategory);
        bookRepository.save(book);
        return bookMapper.toBookResponse(book);
    }
    // 2. Thêm thể loại sách
    @Override
    public BookCategory createBookCategories(BookCategoryRequest request) {
        BookCategory bookCategory = bookMapper.toBookCategory(request);
        return bookCategoryRepository.save(bookCategory);
    }
    // 3. Hiển thị sách theo thể loại
    @Override
    public List<BookSummaryResponse> getBooksByCategory(Integer categoryId) {
        List<Book> book = bookCategoryRepository.findBooksByCategoryId(categoryId.longValue());
        return bookMapper.toBookSummaryResponses(book);
    }

    @Override
    public List<BookCategoryResponse> getAllBookCategories() {
        List<BookCategory> bookCategory = bookCategoryRepository.findAll();
        return bookMapper.toBookCategoryResponses(bookCategory);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        bookRepository.delete(book);
    }

    @Override
    public void deleteBookCategory(Long categoryId) {
        BookCategory bookCategory = bookCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Book category not found with id: " + categoryId));
        bookRepository.deleteBooksByCategoryId(categoryId);
        bookCategoryRepository.delete(bookCategory);
    }

    @Override
    public BookResponse updateBook(Long bookId, BookCreationRequest request) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        BookCategory bookCategory = bookCategoryRepository.findById(request.getBookCategoryId())
                .orElseThrow(() -> new RuntimeException("Book category not found with id: " + request.getBookCategoryId()));
        bookMapper.updateBookFromRequest(request, book);
        book.setBookCategory(bookCategory);
        Book update = bookRepository.save(book);
        return bookMapper.toBookResponse(update);
    }

    @Override
    public BookCategoryResponse updateBookCategory(Long categoryId, BookCategoryRequest request) {
        BookCategory category = bookCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Book category not found with id: " + categoryId));
        category.setCategoryName(request.getCategoryName());
        bookCategoryRepository.save(category);
        return bookCategoryMapper.toBookCategoryResponse(category);
    }
}

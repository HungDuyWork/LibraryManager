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
        if(bookRepository.existsByBookCode(book.getBookCode())) {
            throw new RuntimeException("Book with code " + book.getBookCode() + " already exists.");
        }
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
    public List<BookSummaryResponse> getBooksByCategoryName(String categoryName) {
        BookCategory category = bookCategoryRepository.findByCategoryName(categoryName);
        if (category == null) {
            throw new RuntimeException("Không tìm thấy thể loại: " + categoryName);
        }
        List<Book> books = bookRepository.findBookByBookCategory(category);

        // Map sang DTO
        return bookMapper.toBookSummaryResponses(books);
    }


    @Override
    public List<BookCategoryResponse> getAllBookCategories() {
        List<BookCategory> bookCategory = bookCategoryRepository.findAll();
        return bookMapper.toBookCategoryResponses(bookCategory);
    }

    @Override
    public void deleteBook(String bookCode) {
        Book book = bookRepository.findByBookCode(bookCode);
        if (book == null) {
            throw new RuntimeException("Book not found with code: " + bookCode);
        }
        bookRepository.delete(book);
    }

    @Override
    public void deleteBookCategory(String categoryName) {
        BookCategory bookCategory = bookCategoryRepository.findByCategoryName(categoryName);
        if (bookCategory == null) {
            throw new RuntimeException("Book category not found with name: " + categoryName);
        }
        bookRepository.deleteBooksByCategoryId(bookCategory.getCategoryId());
        bookCategoryRepository.delete(bookCategory);
    }

    @Override
    public BookResponse updateBook(String bookCode, BookCreationRequest request) {
        Book book = bookRepository.findByBookCode(bookCode);
        if (book == null) {
            throw new RuntimeException("Book not found with code: " + bookCode);
        }
        BookCategory bookCategory = bookCategoryRepository.findById(request.getBookCategoryId())
                .orElseThrow(() -> new RuntimeException("Book category not found with id: " + request.getBookCategoryId()));
        bookMapper.updateBookFromRequest(request, book);
        book.setBookCategory(bookCategory);
        Book update = bookRepository.save(book);
        return bookMapper.toBookResponse(update);
    }

    @Override
    public BookCategoryResponse updateBookCategory(String categoryName, BookCategoryRequest request) {
        BookCategory category = bookCategoryRepository.findByCategoryName(categoryName);
        category.setCategoryName(request.getCategoryName());
        bookCategoryRepository.save(category);
        return bookCategoryMapper.toBookCategoryResponse(category);
    }

    @Override
    public BookResponse getBookByCode(String bookCode) {
        Book book = bookRepository.findByBookCode(bookCode);
        if(book == null) {
            throw new RuntimeException("Book not found with code: " + bookCode);
        }
        return bookMapper.toBookResponse(book);
    }

    @Override
    public BookSummaryResponse getBooksByName(String bookName) {
        Book book = bookRepository.findByBookName(bookName);
        if (book == null) {
            throw new RuntimeException("Book not found with name: " + bookName);
        }
        return bookMapper.toBookCategoryResponse(book);
    }

    @Override
    public List<BookSummaryResponse> getBooksByAuthor(String bookAuthor) {
        List<Book> book_author = bookRepository.findByBookAuthor(bookAuthor);
        if (book_author.isEmpty()) {
            throw new RuntimeException("No books found by author: " + bookAuthor);
        }
        return bookMapper.toBookSummaryResponses(book_author);
    }
}

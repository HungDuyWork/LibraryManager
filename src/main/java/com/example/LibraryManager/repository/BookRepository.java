package com.example.LibraryManager.repository;

import com.example.LibraryManager.entity.Book;
import com.example.LibraryManager.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book WHERE book_category = :categoryId", nativeQuery = true)
    void deleteBooksByCategoryId(@Param("categoryId") Long categoryId);

    List<Book> findBookByBookCategory(BookCategory bookCategory);

    @Query(value = "SELECT * FROM book WHERE book_Code = :bookCode", nativeQuery = true)
    Book findByBookCode(@Param("bookCode") String bookCode);

    @Query(value = "SELECT * FROM book WHERE book_Name = :bookName", nativeQuery = true)
    Book findByBookName(@Param("bookName") String bookName);

    boolean existsByBookCode(String bookCode);
    @Query(value = "SELECT * FROM book WHERE book_author = :bookAuthor", nativeQuery = true)
    List<Book> findByBookAuthor(@Param("bookAuthor") String bookAuthor);
}

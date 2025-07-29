package com.example.LibraryManager.repository;

import com.example.LibraryManager.entity.BorrowingBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowingBooksRepository extends JpaRepository<BorrowingBooks, Long> {
    @Query(value = "SELECT * FROM borrowing_books WHERE book_id = :bookId", nativeQuery = true)
    BorrowingBooks findByBookId(@Param("book_id") Long bookId);
}

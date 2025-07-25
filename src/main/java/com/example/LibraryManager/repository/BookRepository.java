package com.example.LibraryManager.repository;

import com.example.LibraryManager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book WHERE book_category = :categoryId", nativeQuery = true)
    void deleteBooksByCategoryId(@Param("categoryId") Long categoryId);
}

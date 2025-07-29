package com.example.LibraryManager.repository;

import com.example.LibraryManager.entity.Book;
import com.example.LibraryManager.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

    @Query(value = "SELECT * FROM book WHERE book_category = :categoryId", nativeQuery = true)
    List<Book> findBooksByCategoryId(@Param("categoryId") Long categoryId);

    boolean existsByCategoryName(String categoryName);
    boolean existsByCategoryId(Long categoryId);
    @Query(value = "SELECT * FROM book_category WHERE category_name = :categoryName", nativeQuery = true)
    BookCategory findByCategoryName(@Param("categoryName") String categoryName);
}


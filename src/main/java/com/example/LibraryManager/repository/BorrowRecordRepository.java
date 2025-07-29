package com.example.LibraryManager.repository;

import com.example.LibraryManager.entity.Book;
import com.example.LibraryManager.entity.BorrowRecord;
import com.example.LibraryManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord,Long> {
    Optional<BorrowRecord> findTopByUserAndBookAndIsReturnedFalseOrderByBorrowedDateDesc(User user, Book book);
    List<BorrowRecord> findAllByUser(User user);
}

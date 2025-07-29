package com.example.LibraryManager.repository;

import com.example.LibraryManager.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE user_email = :userEmail", nativeQuery = true)
    User findByUserEmail(@Param("userEmail") String userEmail);

    @Query(value = "SELECT u.* FROM `user` u " +
            "JOIN borrow_record bb ON u.user_id = bb.user_id " +
            "JOIN book b ON bb.book_id = b.book_id " +
            "WHERE b.book_id = :bookId", nativeQuery = true)
    List<User> findUsersByBookId(@Param("bookId") Long bookId);

}

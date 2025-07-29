package com.example.LibraryManager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "borrowingbooks")
public class BorrowingBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;               // Id của lượt mượn sách

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;             // Người mượn sách

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;             // Sách được mượn

    LocalDate date;        // Ngày mượn sách
}

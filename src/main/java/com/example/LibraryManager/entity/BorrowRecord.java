package com.example.LibraryManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity; // Số lượng

    private LocalDate borrowedDate; // Ngày mượn

    private LocalDate dueDate; // Hạn trả

    private LocalDate returnedDate; // <--- ngày trả thực tế

    private boolean isReturned; // <--- đã trả hay chưa
}

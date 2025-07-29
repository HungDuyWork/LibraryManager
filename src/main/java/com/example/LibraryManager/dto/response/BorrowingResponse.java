package com.example.LibraryManager.dto.response;

import com.example.LibraryManager.entity.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowingResponse {
    Book book;
    int quantity;
    LocalDate borrowedDate;
    LocalDate dueDate;
    LocalDate returnedDate; // Ngày trả thực tế
    boolean isReturned; // Đã trả hay chưa
}

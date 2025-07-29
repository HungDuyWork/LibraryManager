package com.example.LibraryManager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowedBookResponse {
    String bookName;
    String bookAuthor;
    int quantity;
    LocalDate borrowedDate;
    LocalDate dueDate;
    LocalDate returnedDate;
    boolean returned;
}

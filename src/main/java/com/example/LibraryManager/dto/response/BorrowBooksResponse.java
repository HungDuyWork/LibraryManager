package com.example.LibraryManager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowBooksResponse {
    List<BorrowedBookResponse> borrowedBooks;
}

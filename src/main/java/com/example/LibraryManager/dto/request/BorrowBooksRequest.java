package com.example.LibraryManager.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BorrowBooksRequest {
    String userEmail;
    List<String> bookNames;
}

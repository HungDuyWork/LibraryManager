package com.example.LibraryManager.service;

import com.example.LibraryManager.dto.response.BorrowBooksResponse;

public interface BorrowingService {
    BorrowBooksResponse getBorrowHistory(String userEmail);
}

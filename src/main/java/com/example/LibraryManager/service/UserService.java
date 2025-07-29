package com.example.LibraryManager.service;

import com.example.LibraryManager.dto.request.BorrowBooksRequest;
import com.example.LibraryManager.dto.request.ReturnBooksRequest;
import com.example.LibraryManager.dto.request.UserCreationRequest;
import com.example.LibraryManager.dto.response.BorrowBooksResponse;
import com.example.LibraryManager.dto.response.BorrowedBookResponse;
import com.example.LibraryManager.dto.response.UserResponse;

public interface UserService {
    // 1. Đăng ký
    UserResponse addUser(UserCreationRequest request);
    // 2. Update user
    UserResponse updateUser(String userEmail, UserCreationRequest request);
    // 4. Người dùng mượn nhiều sách
    BorrowBooksResponse borrowBooks(BorrowBooksRequest request);
    // 5. Người dùng trả sách
    BorrowBooksResponse returnBooks(ReturnBooksRequest request);
}

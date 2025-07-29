package com.example.LibraryManager.service;

import com.example.LibraryManager.dto.response.UserResponse;

import java.util.List;

public interface AdminService {
    // 1. Tìm kiếm tất cả người dùng đang mượn cuốn sách có tên "{bookName}"
    List<UserResponse> getUsersByBorrowedBookName(String bookName);
}

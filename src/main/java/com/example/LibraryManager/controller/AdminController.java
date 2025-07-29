package com.example.LibraryManager.controller;

import com.example.LibraryManager.dto.response.ApiResponse;
import com.example.LibraryManager.dto.response.UserResponse;
import com.example.LibraryManager.service.AdminService;
import com.example.LibraryManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    // 1. Tìm kiếm tất cả người dùng đang mượn cuốn sách có tên "{bookName}"
    @GetMapping("/users/borrowed-books/{bookName}")
    ApiResponse<List<UserResponse>> getUsersByBorrowedBookName(@PathVariable String bookName) {
        return ApiResponse.<List<UserResponse>>builder()
                .result(adminService.getUsersByBorrowedBookName(bookName))
                .build();
    }
}

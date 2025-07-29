package com.example.LibraryManager.controller;

import com.example.LibraryManager.dto.request.BorrowBooksRequest;
import com.example.LibraryManager.dto.request.ReturnBooksRequest;
import com.example.LibraryManager.dto.request.UserCreationRequest;
import com.example.LibraryManager.dto.response.ApiResponse;
import com.example.LibraryManager.dto.response.BorrowBooksResponse;
import com.example.LibraryManager.dto.response.UserResponse;
import com.example.LibraryManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;
    // 1. Đăng ký
    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.addUser(request))
                .build();
    }
    // 2. Update user dựa trên email
    @PutMapping("/{userEmail}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userEmail, @RequestBody UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(userEmail,request))
                .build();
    }
    // 4. Người dùng mượn sách - mỗi lần nhiều cuốn với số lượng 1
    @PostMapping("/borrow/multiple")
    public ApiResponse<BorrowBooksResponse> borrowBooks(@RequestBody BorrowBooksRequest request) {
        return ApiResponse.<BorrowBooksResponse>builder()
                .result(userService.borrowBooks(request))
                .build();
    }
//     5. Người dùng trả sách - mỗi lần trả nhiều cuốn
    @PostMapping("/return")
    public ApiResponse<BorrowBooksResponse> returnBooks(@RequestBody ReturnBooksRequest request) {
        return ApiResponse.<BorrowBooksResponse>builder()
            .result(userService.returnBooks(request))
            .build();
    }

}

package com.example.LibraryManager.controller;

import com.example.LibraryManager.dto.response.ApiResponse;
import com.example.LibraryManager.dto.response.BorrowBooksResponse;

import com.example.LibraryManager.service.BorrowingService;
import com.example.LibraryManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
    @Autowired
    private UserService userService;
    @Autowired
    private BorrowingService borrowingService;
    @GetMapping("/history")
    public ApiResponse<BorrowBooksResponse> getBorrowHistory(@RequestParam String userEmail) {
        return ApiResponse.<BorrowBooksResponse>builder()
                .result(borrowingService.getBorrowHistory(userEmail))
                .build();
    }


}

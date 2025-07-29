package com.example.LibraryManager.controller;

import com.example.LibraryManager.dto.request.DeptCreationRequest;
import com.example.LibraryManager.dto.response.ApiResponse;
import com.example.LibraryManager.dto.response.DeptResponse;
import com.example.LibraryManager.entity.Dept;
import com.example.LibraryManager.service.Impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;
    // 1. Thêm mới dept
    @PostMapping
    ApiResponse<DeptResponse> createDept(@RequestBody DeptCreationRequest request) {
        return ApiResponse.<DeptResponse>builder()
                .result(deptService.createDept(request))
                .build();
    }
    // 2. Hiển thị tất cả dept
    @GetMapping
    ApiResponse<List<DeptResponse>> findAllDepts() {
        return ApiResponse.<List<DeptResponse>> builder()
                .result(deptService.findAllDepts())
                .build();
    }
    // 3. Xoá dept theo tên
    @DeleteMapping("/{deptName}")
    void deleteDept(@PathVariable("deptName") String deptName) {
        deptService.deleteDept(deptName);
    }
    // 4. Cập nhật dept theo ID
    @PutMapping("/{deptName}")
    ApiResponse<DeptResponse> updateDept(@PathVariable("deptName") String deptName, @RequestBody DeptCreationRequest request) {
        return ApiResponse.<DeptResponse>builder()
                .result(deptService.updateDept(deptName, request))
                .build();
    }
}

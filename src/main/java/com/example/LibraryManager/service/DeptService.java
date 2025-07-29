package com.example.LibraryManager.service;

import com.example.LibraryManager.dto.request.DeptCreationRequest;
import com.example.LibraryManager.dto.response.DeptResponse;

import java.util.List;

public interface DeptService {
    // 1. Thêm mới dept
    DeptResponse createDept(DeptCreationRequest request);
    // 2. Hiển thị tất cả dept
    List<DeptResponse> findAllDepts(); // Uncomment if needed
    // 3. Xoá dept theo tên
    void deleteDept(String deptName); // Uncomment if needed
    // 4. Cập nhật dept theo Tên
    DeptResponse updateDept(String deptName, DeptCreationRequest request); // Uncomment if needed
}

package com.example.LibraryManager.service.Impl;

import com.example.LibraryManager.dto.request.DeptCreationRequest;
import com.example.LibraryManager.dto.response.DeptResponse;
import com.example.LibraryManager.entity.Dept;
import com.example.LibraryManager.map.DeptMapper;
import com.example.LibraryManager.repository.DeptRepository;
import com.example.LibraryManager.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public DeptResponse createDept(DeptCreationRequest request) {
        Dept dept = deptMapper.createDept(request);
        return deptMapper.deptToResponse(deptRepository.save(dept));
    }

    @Override
    public List<DeptResponse> findAllDepts() {
        List<Dept> depts = deptRepository.findAll();
        return depts.stream()
                .map(deptMapper::deptToResponse)
                .toList();
    }

    @Override
    public void deleteDept(String deptName) {
        Dept dept = deptRepository.findByDeptName(deptName);
        if (dept == null) {
            throw new RuntimeException("Không tìm thấy dept với tên: " + deptName);
        }
        deptRepository.delete(dept);
    }

    @Override
    public DeptResponse updateDept(String deptName, DeptCreationRequest request) {
        Dept dept = deptRepository.findByDeptName(deptName);
        if (dept == null) {
            throw new RuntimeException("Không tìm thấy dept với tên: " + deptName);
        }
        deptMapper.updateDept(request, dept);
        Dept updatedDept = deptRepository.save(dept);
        return deptMapper.deptToResponse(updatedDept);
    }
}

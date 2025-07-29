package com.example.LibraryManager.repository;

import com.example.LibraryManager.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeptRepository extends JpaRepository<Dept,Long> {
    @Query(value = "SELECT * FROM dept WHERE dept_name = :deptName", nativeQuery = true)
    Dept findByDeptName(@Param("deptName") String deptName);
}

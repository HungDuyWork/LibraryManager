package com.example.LibraryManager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "dept")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long deptId;      // Id của khoa hoặc viện
    String deptName;  // Tên của khoa/vien (ví dụ: Khoa CNTT, Điện tử, Thể thao...)
    @OneToMany(mappedBy = "dept")
    List<User> users; // Danh sách người dùng trong khoa này
}

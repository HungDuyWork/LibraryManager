package com.example.LibraryManager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;        // Id của người dùng
    String name;       // Tên của người dùng
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate; // Ngày sinh của người dùng
    String userName;    // Tên đăng nhập
    String userPwd;     // Mật khẩu
    String userEmail;   // Email của người dùng
    @ManyToOne
    @JoinColumn(name = "dept_id")
    Dept dept; // Khoa/viện mà người dùng thuộc về
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role; // Vai trò của user: ADMIN, USER...

}

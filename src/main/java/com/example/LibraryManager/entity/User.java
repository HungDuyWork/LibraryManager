package com.example.LibraryManager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    String userName;    // Tên đăng nhập
    String userPwd;     // Mật khẩu
    String userEmail;   // Email của người dùng
    @ManyToOne
    @JoinColumn(name = "dept_id")
    Dept dept; // Khoa/viện mà người dùng thuộc về

}

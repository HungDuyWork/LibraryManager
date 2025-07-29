package com.example.LibraryManager.dto.response;

import com.example.LibraryManager.entity.Dept;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    String name;       // Tên của người dùng
    LocalDate birthDate; // Ngày sinh của người dùng
    Dept dept; // Khoa/viện mà người dùng thuộc về

}

package com.example.LibraryManager.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationRequest {
    @NotNull(message = "Tên đăng nhập không được để trống")
    String userName;    // Tên đăng nhập
    @NotNull(message = "Tên người dùng không được để trống")
    String name;       // Tên của người dùng
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthDate; // Ngày sinh của người dùng
    @Size(min = 6, max = 20, message = "Mật khẩu phải có độ dài từ 6 đến 20 ký tự")
    String userPwd;     // Mật khẩu
    @Email(message = "Email không hợp lệ")
    String userEmail;   // Email của người dùng
    Long deptId;        // Id của khoa/viện mà người dùng thuộc về
}

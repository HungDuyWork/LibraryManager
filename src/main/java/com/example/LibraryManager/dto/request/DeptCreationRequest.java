package com.example.LibraryManager.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptCreationRequest {
    String deptName;  // Tên của khoa/vien (ví dụ: Khoa CNTT, Điện tử, Thể thao...)
}

package com.example.LibraryManager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptResponse {
    Long deptId;          // Id của khoa/viện
    String deptName;
}

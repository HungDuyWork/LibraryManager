package com.example.LibraryManager.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCategoryRequest {
    String categoryName;  // Tên thể loại (ví dụ: Tiểu thuyết, Lịch sử, ...)
}

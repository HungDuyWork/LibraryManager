package com.example.LibraryManager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCategoryResponse {
    String categoryName;  // Tên thể loại (ví dụ: Tiểu thuyết, Lịch sử, ...)
}

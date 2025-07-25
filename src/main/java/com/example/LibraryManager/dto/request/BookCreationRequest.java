package com.example.LibraryManager.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreationRequest {
    String bookName;             // Tên sách
    String bookAuthor;           // Tác giả
    String bookPublish;          // Nhà xuất bản
    Double bookPrice;            // Giá sách
    String bookIntroduction;     // Giới thiệu sơ lược về sách
    Long bookCategoryId;         // Thể loại sách
}

package com.example.LibraryManager.dto.response;

import com.example.LibraryManager.entity.BookCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookResponse {
    Long bookId;                 // Id của sách
    String bookName;             // Tên sách
    String bookAuthor;           // Tác giả
    String bookPublish;          // Nhà xuất bản
    Double bookPrice;            // Giá sách
    String bookIntroduction;     // Giới thiệu sơ lược về sách
    BookCategory bookCategory;   // Thể loại sách (liên kết khóa ngoại đến bảng category)

}

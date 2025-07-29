package com.example.LibraryManager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookSummaryResponse {
    String bookName;             // Tên sách
    String bookAuthor;           // Tác giả
    Double bookPrice;            // Giá sách
    String bookCode;            // Mã sách
    Integer bookQuantity;        // Số lượng sách hiện có

}

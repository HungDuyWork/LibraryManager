package com.example.LibraryManager.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreationRequest {
    @NotNull(message = "Tên sách không được để trống")
    String bookName;             // Tên sách
    @NotNull(message = "Tác giả không được để trống")
    String bookAuthor;           // Tác giả
    @NotNull(message = "Nhà xuất bản không được để trống")
    String bookPublish;          // Nhà xuất bản
    @NotNull(message = "Giá sách không được để trống")
    @Positive(message = "Giá sách phải là một số dương")
    Double bookPrice;            // Giá sách
    @NotNull(message = "Số lượng sách không được để trống")
    Integer bookQuantity;        // Số lượng sách hiện có
    @NotNull(message = "Mã sách không được để trống")
    String bookCode;
    @NotNull(message = "Không được để trống")
    String bookIntroduction;     // Giới thiệu sơ lược về sách
    @NotNull(message = "Không được để trống")
    Long bookCategoryId;         // Thể loại sách
}

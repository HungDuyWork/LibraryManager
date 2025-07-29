package com.example.LibraryManager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bookId;                 // Id của sách
    String bookName;             // Tên sách
    String bookAuthor;           // Tác giả
    String bookPublish;          // Nhà xuất bản
    Double bookPrice;            // Giá sách
    Integer bookQuantity;        // Số lượng sách hiện có
    String bookCode;
    String bookIntroduction;     // Giới thiệu sơ lược về sách
    @ManyToOne
    @JoinColumn(name = "book_category")
    BookCategory bookCategory;   // Thể loại sách (liên kết khóa ngoại đến bảng category)

}
